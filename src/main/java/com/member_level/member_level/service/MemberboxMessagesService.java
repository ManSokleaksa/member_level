package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.MemberboxMessagesDto;

import java.util.List;

public interface MemberboxMessagesService {
    List<MemberboxMessagesDto> getAllMemberboxMessages();
    MemberboxMessagesDto getMemberboxMessageById(String id);
    MemberboxMessagesDto createMemberboxMessage(MemberboxMessagesDto memberBoxMessagesDto);
    MemberboxMessagesDto updateMemberboxMessage(String id, MemberboxMessagesDto memberBoxMessagesDto);
    void deleteMemberboxMessage(String id);
}
