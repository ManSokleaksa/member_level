package com.member_level.member_level.controller;

import com.member_level.member_level.constants.AppConstant;
import com.member_level.member_level.dto.response.ApiResponse;
import com.member_level.member_level.dto.request.MemberboxMessagesDto;
import com.member_level.member_level.service.MemberboxMessagesService;
import com.member_level.member_level.util.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memberbox_messages")
public class MemberBoxMessagesController {

    @Autowired
    private MemberboxMessagesService memberboxMessagesService;

    @Operation(summary = "Get All MemberBox Messages", description = "Fetch all member box messages")
    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberboxMessagesDto>>> getAllMemberboxMessages() {
        List<MemberboxMessagesDto> memberboxMessages = memberboxMessagesService.getAllMemberboxMessages();
        ApiResponse<List<MemberboxMessagesDto>> response = ApiResponseUtil.createApiResponse(
                memberboxMessages,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGES_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get MemberBox Message by ID", description = "Fetch member box message details by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberboxMessagesDto>> getMemberboxMessageById(
            @Parameter(description = "ID of the member box message to fetch", required = true)
            @PathVariable String id) {
        MemberboxMessagesDto memberboxMessage = memberboxMessagesService.getMemberboxMessageById(id);
        ApiResponse<MemberboxMessagesDto> response = ApiResponseUtil.createApiResponse(
                memberboxMessage,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGE_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create MemberBox Message", description = "Create a new member box message")
    @PostMapping
    public ResponseEntity<ApiResponse<MemberboxMessagesDto>> createMemberboxMessage(
            @Parameter(description = "Member box message details", required = true)
            @RequestBody MemberboxMessagesDto memberboxMessagesDto) {
        MemberboxMessagesDto createdMemberboxMessage = memberboxMessagesService.createMemberboxMessage(memberboxMessagesDto);
        ApiResponse<MemberboxMessagesDto> response = ApiResponseUtil.createApiResponse(
                createdMemberboxMessage,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGE_CREATION_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update MemberBox Message", description = "Update an existing member box message")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberboxMessagesDto>> updateMemberboxMessage(
            @Parameter(description = "ID of the member box message to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Updated member box message details", required = true)
            @RequestBody MemberboxMessagesDto memberboxMessagesDto) {
        MemberboxMessagesDto updatedMemberboxMessage = memberboxMessagesService.updateMemberboxMessage(id, memberboxMessagesDto);
        ApiResponse<MemberboxMessagesDto> response = ApiResponseUtil.createApiResponse(
                updatedMemberboxMessage,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGE_UPDATE_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete MemberBox Message", description = "Delete a member box message by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMemberboxMessage(
            @Parameter(description = "ID of the member box message to delete", required = true)
            @PathVariable String id) {
        memberboxMessagesService.deleteMemberboxMessage(id);
        ApiResponse<Void> response = ApiResponseUtil.createApiResponse(
                null,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.MEMBERBOX_MESSAGE_DELETE_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }
}
