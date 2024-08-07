package com.member_level.member_level.controller;


import com.member_level.member_level.dto.response.ApiResponse;
import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.service.MemberLevelService;
import com.member_level.member_level.util.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    @Operation(summary = "Get Member Level by Card Number", description = "Fetch member level details by card number")
    @GetMapping("/member_level")
    public ResponseEntity<ApiResponse<MemberLevelDto>> getMemberLevel(
            @Parameter(description = "Card number to fetch member level", required = true)
            @RequestParam("cardNumber") String cardNumber){
        MemberLevelDto memberLevel = memberLevelService.getMemberLevelByCard(cardNumber);
        ApiResponse<MemberLevelDto> response = ApiResponseUtil.createApiResponse(
                memberLevel,
                0, // No error
                1, // Success code
                "Member level fetched successfully"
        );
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Create Member Level", description = "Create member level")
    @PostMapping("/member_level")
    public ResponseEntity<ApiResponse<MemberLevelDto>> createMemberLevel(
            @Parameter(description = "Create member level", required = true)
            @RequestBody MemberLevelDto memberLevelDto){
        MemberLevelDto createdMemberLevel = memberLevelService.createMemberLevel(memberLevelDto);
        ApiResponse<MemberLevelDto> response = ApiResponseUtil.createApiResponse(
                createdMemberLevel,
                0, // No error
                1, // Success code
                "Member level created successfully"
        );
        return ResponseEntity.ok(response);
    }
}
