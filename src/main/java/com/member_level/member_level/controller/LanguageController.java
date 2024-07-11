package com.member_level.member_level.controller;

import com.member_level.member_level.constants.AppConstant;
import com.member_level.member_level.dto.response.ApiResponse;
import com.member_level.member_level.dto.request.LanguageDto;
import com.member_level.member_level.service.LanguageService;
import com.member_level.member_level.util.ApiResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @Operation(summary = "Get All Languages", description = "Fetch all languages")
    @GetMapping
    public ResponseEntity<ApiResponse<List<LanguageDto>>> getAllLanguages() {
        List<LanguageDto> languages = languageService.getAllLanguages();
        ApiResponse<List<LanguageDto>> response = ApiResponseUtil.createApiResponse(
                languages,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.LANGUAGE_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Language by ID", description = "Fetch language details by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LanguageDto>> getLanguageById(
            @Parameter(description = "ID of the language to fetch", required = true)
            @PathVariable int id) {
        LanguageDto language = languageService.getLanguageById(id);
        ApiResponse<LanguageDto> response = ApiResponseUtil.createApiResponse(
                language,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.LANGUAGE_FETCH_SUCCESS
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create Language", description = "Create a new language")
    @PostMapping
    public ResponseEntity<ApiResponse<LanguageDto>> createLanguage(
            @Parameter(description = "Language details", required = true)
            @RequestBody LanguageDto languageDto) {
        LanguageDto createdLanguage = languageService.createLanguage(languageDto);
        ApiResponse<LanguageDto> response = ApiResponseUtil.createApiResponse(
                createdLanguage,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.LANGUAGE_CREATION_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update Language", description = "Update an existing language")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LanguageDto>> updateLanguage(
            @Parameter(description = "ID of the language to update", required = true)
            @PathVariable int id,
            @Parameter(description = "Updated language details", required = true)
            @RequestBody LanguageDto languageDto) {
        LanguageDto updatedLanguage = languageService.updateLanguage(id, languageDto);
        ApiResponse<LanguageDto> response = ApiResponseUtil.createApiResponse(
                updatedLanguage,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.LANGUAGE_UPDATE_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete Language", description = "Delete a language by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLanguage(
            @Parameter(description = "ID of the language to delete", required = true)
            @PathVariable int id) {
        languageService.deleteLanguage(id);
        ApiResponse<Void> response = ApiResponseUtil.createApiResponse(
                null,
                AppConstant.ERROR_CODE_ZERO, // No error
                AppConstant.RESPONSE_CODE_ZERO, // Success code
                AppConstant.LANGUAGE_DELETE_SUCCESSFUL
        );
        return ResponseEntity.ok(response);
    }
}
