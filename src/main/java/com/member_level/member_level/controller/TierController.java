package com.member_level.member_level.controller;

import com.member_level.member_level.constants.AppConstant;
import com.member_level.member_level.dto.response.ApiResponse;
import com.member_level.member_level.dto.request.TierDto;
import com.member_level.member_level.service.TierService;
import com.member_level.member_level.util.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiers")
public class TierController {

    @Autowired
    private TierService tierService;

    @Operation(summary = "Get All Tiers", description = "Get All Tiers")
    @GetMapping
    public ResponseEntity<ApiResponse<List<TierDto>>> getAllTiers(){
        List<TierDto> getAllTiers = tierService.getAllTiers();
        ApiResponse<List<TierDto>> response = ApiResponseUtil.createApiResponse(
                getAllTiers,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.TIER_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create Tier", description = "Create Tier")
    @PostMapping
    public ResponseEntity<ApiResponse<TierDto>> createTier(
            @Parameter(description = "Create tier", required = true)
            @RequestBody TierDto tierDto){
        TierDto createTier = tierService.createTier(tierDto);
        ApiResponse<TierDto> response = ApiResponseUtil.createApiResponse(
                createTier,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.TIER_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }
}
