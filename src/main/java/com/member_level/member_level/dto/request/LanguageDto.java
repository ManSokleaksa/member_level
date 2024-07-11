package com.member_level.member_level.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    private Boolean status;
    private Boolean isDeleted;

}
