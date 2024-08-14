package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.dto.response.MemberLevelResponse;

public interface MemberLevelService {

    MemberLevelResponse getMemberLevelByCard(String card);
    MemberLevelResponse createMemberLevel(MemberLevelDto memberLevelDto);
}
