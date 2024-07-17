package com.member_level.member_level.service.impl;

import com.member_level.member_level.dto.request.MemberboxMessagesDto;
import com.member_level.member_level.entity.Language;
import com.member_level.member_level.entity.MemberboxMessages;
import com.member_level.member_level.entity.Tiers;
import com.member_level.member_level.mapper.MemberboxMessagesMapper;
import com.member_level.member_level.repository.LanguageRepository;
import com.member_level.member_level.repository.MemberboxMessagesRepository;
import com.member_level.member_level.repository.TierRepository;
import com.member_level.member_level.service.MemberboxMessagesService;
import com.member_level.member_level.util.EntityFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberboxMessagesServiceImpl implements MemberboxMessagesService {

    private static final Logger logger = LoggerFactory.getLogger(MemberboxMessagesServiceImpl.class);

    private final MemberboxMessagesRepository memberboxMessagesRepository;
    private final LanguageRepository languageRepository;
    private final TierRepository tierRepository;

    public MemberboxMessagesServiceImpl(MemberboxMessagesRepository memberboxMessagesRepository, LanguageRepository languageRepository, TierRepository tierRepository) {
        this.memberboxMessagesRepository = memberboxMessagesRepository;
        this.languageRepository = languageRepository;
        this.tierRepository = tierRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberboxMessagesDto> getAllMemberboxMessages() {
        logger.info("Fetching all member box messages");
        return memberboxMessagesRepository.findByIsDeletedFalse().stream()
                .map(MemberboxMessagesMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MemberboxMessagesDto getMemberboxMessageById(String id) {
        logger.info("Fetching member box message with id: {}", id);
        MemberboxMessages memberBoxMessages = EntityFinder.findById(memberboxMessagesRepository, id, "Member box message");
        return MemberboxMessagesMapper.INSTANCE.toDto(memberBoxMessages);
    }

    @Override
    @Transactional
    public MemberboxMessagesDto createMemberboxMessage(MemberboxMessagesDto memberBoxMessagesDto) {
        logger.info("Creating new member box message with details: {}", memberBoxMessagesDto);
        MemberboxMessages memberBoxMessages = MemberboxMessagesMapper.INSTANCE.toEntity(memberBoxMessagesDto);
        setRelatedEntities(memberBoxMessages, memberBoxMessagesDto.getLanguageId(), memberBoxMessagesDto.getTiersId());
        MemberboxMessages savedMemberBoxMessages = memberboxMessagesRepository.save(memberBoxMessages);
        return MemberboxMessagesMapper.INSTANCE.toDto(savedMemberBoxMessages);
    }

    @Override
    @Transactional
    public MemberboxMessagesDto updateMemberboxMessage(String id, MemberboxMessagesDto memberboxMessagesDto) {
        logger.info("Updating member box message with id: {}", id);
        MemberboxMessages existingMemberBoxMessages = EntityFinder.findById(memberboxMessagesRepository, id, "Member box message");
        setRelatedEntities(existingMemberBoxMessages, memberboxMessagesDto.getLanguageId(), memberboxMessagesDto.getTiersId());
        existingMemberBoxMessages.setMessage(memberboxMessagesDto.getMessage());
        existingMemberBoxMessages.setTermAndCondition(memberboxMessagesDto.getTermAndCondition());
        existingMemberBoxMessages.setMessageOverBean(memberboxMessagesDto.getMessageOverBean());
        existingMemberBoxMessages.setIsDeleted(memberboxMessagesDto.getIsDeleted() != null ? memberboxMessagesDto.getIsDeleted() : false);
        existingMemberBoxMessages.setStatus(memberboxMessagesDto.getStatus() != null ? memberboxMessagesDto.getStatus() : true);
        MemberboxMessages updatedMemberBoxMessages = memberboxMessagesRepository.save(existingMemberBoxMessages);
        return MemberboxMessagesMapper.INSTANCE.toDto(updatedMemberBoxMessages);
    }

    @Override
    @Transactional
    public void deleteMemberboxMessage(String id) {
        logger.info("Deleting member box message with id: {}", id);
        MemberboxMessages existingMemberboxMessages = EntityFinder.findById(memberboxMessagesRepository, id, "Member box message");
        existingMemberboxMessages.setIsDeleted(true);
        memberboxMessagesRepository.save(existingMemberboxMessages);
    }

    private void setRelatedEntities(MemberboxMessages memberBoxMessages, String languageId, String tierId) {
        Language language = EntityFinder.findById(languageRepository, languageId, "Language");
        Tiers tiers = EntityFinder.findById(tierRepository, tierId, "Tier");
        memberBoxMessages.setLanguage(language);
        memberBoxMessages.setTiers(tiers);
    }
}
