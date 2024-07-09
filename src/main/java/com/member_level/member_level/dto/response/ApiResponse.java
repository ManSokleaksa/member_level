package com.member_level.member_level.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private Integer errorCode;
    private Integer responseCode;
    private String message;
    private Long timestamp;

    // Getters and Setters
}
