package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.dto.response.MemberLevelResponse;

import java.util.List;

public interface MemberLevelService {

    List<MemberLevelResponse> getAllMemberLevel();
    MemberLevelResponse getMemberLevelByCard(String card);
    MemberLevelResponse createMemberLevel(MemberLevelDto memberLevelDto);
    MemberLevelResponse updateMemberLevel(String id, MemberLevelDto memberLevelDto);
}
