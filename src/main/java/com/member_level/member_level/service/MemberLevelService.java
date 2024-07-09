package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.MemberLevelDto;

public interface MemberLevelService {

    MemberLevelDto getMemberLevelByCard(String card);
    MemberLevelDto createMemberLevel(MemberLevelDto memberLevelDto);
}
