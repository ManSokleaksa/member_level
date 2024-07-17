package com.member_level.member_level.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberboxMessagesDto {
    private String languageId;
    private String tiersId;
    private String message;
    private String termAndCondition;
    private String messageOverBean;
    private Boolean isDeleted;
    private Boolean status;
}
