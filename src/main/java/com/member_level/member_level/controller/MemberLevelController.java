package com.member_level.member_level.controller;


import com.member_level.member_level.constants.AppConstant;
import com.member_level.member_level.dto.request.MemberboxMessagesDto;
import com.member_level.member_level.dto.response.ApiResponse;
import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.dto.response.MemberLevelResponse;
import com.member_level.member_level.service.MemberLevelService;
import com.member_level.member_level.util.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    @Operation(summary = "Get All Member Level", description = "Fetch all member level")
    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberLevelResponse>>> getAllMemberLevel() {
        List<MemberLevelResponse> memberLevels = memberLevelService.getAllMemberLevel();
        ApiResponse<List<MemberLevelResponse>> response = ApiResponseUtil.createApiResponse(
                memberLevels,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGES_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Member Level by Card Number", description = "Fetch member level details by card number")
    @GetMapping("/member_level")
    public ResponseEntity<ApiResponse<MemberLevelResponse>> getMemberLevel(
            @Parameter(description = "Card number to fetch member level", required = true)
            @RequestParam("cardNumber") String cardNumber){
        MemberLevelResponse memberLevel = memberLevelService.getMemberLevelByCard(cardNumber);
        ApiResponse<MemberLevelResponse> response = ApiResponseUtil.createApiResponse(
                memberLevel,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBER_LEVEL_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Create Member Level", description = "Create member level")
    @PostMapping("/member_level")
    public ResponseEntity<ApiResponse<MemberLevelResponse>> createMemberLevel(
            @Parameter(description = "Create member level", required = true)
            @RequestBody MemberLevelDto memberLevelDto){
        MemberLevelResponse createdMemberLevel = memberLevelService.createMemberLevel(memberLevelDto);
        ApiResponse<MemberLevelResponse> response = ApiResponseUtil.createApiResponse(
                createdMemberLevel,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBER_LEVEL_CREATION_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Update Member Level", description = "Update an existing member level")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberLevelResponse>> updateMemberboxMessage(
            @Parameter(description = "ID of the member level to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Updated member level ", required = true)
            @RequestBody MemberLevelDto memberLevelDto) {
        MemberLevelResponse updatedMemberLevel = memberLevelService.updateMemberLevel(id, memberLevelDto);
        ApiResponse<MemberLevelResponse> response = ApiResponseUtil.createApiResponse(
                updatedMemberLevel,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBER_LEVEL_UPDATE_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }
}
