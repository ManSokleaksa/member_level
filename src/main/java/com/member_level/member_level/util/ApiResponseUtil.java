package com.member_level.member_level.util;

import com.member_level.member_level.dto.response.ApiResponse;

import java.time.Instant;

public class ApiResponseUtil {
    public static <T> ApiResponse<T> createApiResponse(T data, Integer errorCode, Integer responseCode, String responseMessage) {
        Long responseTimestamp = Instant.now().toEpochMilli();
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setErrorCode(errorCode);
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setTimestamp(responseTimestamp);
        return response;
    }
}
