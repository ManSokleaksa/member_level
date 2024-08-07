package com.member_level.member_level.service.impl;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.entity.LoyaltyCards;
import com.member_level.member_level.mapper.MemberLevelMapper;
import com.member_level.member_level.repository.MemberLevelRepository;
import com.member_level.member_level.service.MemberLevelService;
import org.springframework.stereotype.Service;

@Service
public class MemberLevelServiceImpl implements MemberLevelService {

    private final MemberLevelRepository memberLevelRepository;


    public MemberLevelServiceImpl(MemberLevelRepository memberLevelRepository) {
        this.memberLevelRepository = memberLevelRepository;
    }

    @Override
    public MemberLevelDto getMemberLevelByCard(String card) {
        LoyaltyCards loyaltyCards = memberLevelRepository.findMemberLevelByCardNumber(card);
                //.orElseThrow(() -> new ResourceNotFoundException("MemberLevel not found with card number: " + card));
        return MemberLevelMapper.INSTANCE.toDto(loyaltyCards);
    }

    @Override
    public MemberLevelDto createMemberLevel(MemberLevelDto memberLevelDto) {
        LoyaltyCards loyaltyCards = MemberLevelMapper.INSTANCE.toEntity(memberLevelDto);
        LoyaltyCards savedLoyaltyCards = memberLevelRepository.save(loyaltyCards);
        return MemberLevelMapper.INSTANCE.toDto(savedLoyaltyCards);
    }
}
