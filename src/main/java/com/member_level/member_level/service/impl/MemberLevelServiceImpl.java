package com.member_level.member_level.service.impl;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.dto.response.MemberLevelResponse;
import com.member_level.member_level.entity.LoyaltyCards;
import com.member_level.member_level.entity.MemberboxMessages;
import com.member_level.member_level.entity.Tiers;
import com.member_level.member_level.mapper.MemberLevelMapper;
import com.member_level.member_level.repository.MemberLevelRepository;
import com.member_level.member_level.repository.MemberboxMessagesRepository;
import com.member_level.member_level.repository.TierRepository;
import com.member_level.member_level.service.MemberLevelService;
import com.member_level.member_level.util.EntityFinder;
import com.member_level.member_level.util.Helper;
import com.member_level.member_level.util.MemberLevelUtil;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberLevelServiceImpl implements MemberLevelService {

    private static final Logger logger = LoggerFactory.getLogger(MemberboxMessagesServiceImpl.class);

    private final MemberLevelRepository memberLevelRepository;
    private final TierRepository tierRepository;
    private final MemberboxMessagesRepository memberboxMessagesRepository;


    public MemberLevelServiceImpl(MemberLevelRepository memberLevelRepository, TierRepository tierRepository, MemberboxMessagesRepository memberboxMessagesRepository) {
        this.memberLevelRepository = memberLevelRepository;
        this.tierRepository = tierRepository;
        this.memberboxMessagesRepository = memberboxMessagesRepository;
    }

    @Override
    public MemberLevelResponse getMemberLevelByCard(String card) {
        // Check if the card exists in the loyalty card
        LoyaltyCards loyaltyCards = memberLevelRepository.findByCardNumber(card)
                .orElseThrow(() -> new EntityNotFoundException("MemberLevel not found with card number: " + card));

        // Get member box messages
        MemberboxMessages memberboxMessages = memberboxMessagesRepository.findByTiersId(loyaltyCards.getTiers().getId());
        if (memberboxMessages == null) {
            throw new EntityNotFoundException("MemberboxMessages not found for tier ID: " + loyaltyCards.getTiers().getId());
        }

        // Get the tier based on the loyalty card's level
        Tiers tiers = tierRepository.findByLevel(loyaltyCards.getTiers().getLevel());
        if (tiers == null) {
            throw new EntityNotFoundException("Tier not found for level: " + loyaltyCards.getTiers().getLevel());
        }

        // Replace placeholders in each message
        String tier = loyaltyCards.getTiers().getName();
        int beanNeed = tiers.getBeanNeed();
        String memberPercentage = String.valueOf(loyaltyCards.getBeans());
        String dob = "your_date_of_birth_here";
        Date tierExpireDate = loyaltyCards.getTierExpireDate();
        String message;

        // Check condition bean over 100
        if (loyaltyCards.getBeans() >= beanNeed && Objects.equals(loyaltyCards.getTiers().getId(), memberboxMessages.getTiers().getId())) {
            logger.info("Beans needed: {}", beanNeed);
            message = memberboxMessages.getMessageOverBean();
        } else {
            message = memberboxMessages.getMessage();
        }

        // Create MemberInfo object
        MemberLevelUtil.MemberInfo memberInfo = new MemberLevelUtil.MemberInfo(
                tier,
                memberPercentage,
                dob,
                loyaltyCards.getBeans(),
                tierExpireDate,
                loyaltyCards.getTiers().getBeanNeed() - loyaltyCards.getBeans()
        );

        // Replace Member info into message box
        String messages = MemberLevelUtil.replacePlaceHolders(message, memberInfo);

        // Return message and term & condition
        MemberLevelResponse response = MemberLevelMapper.INSTANCE.toResponseDto(loyaltyCards);
        response.setMessage(messages);
        response.setTermCondition(memberboxMessages.getTermAndCondition());
        return response;
    }


    @Override
    public MemberLevelResponse createMemberLevel(MemberLevelDto memberLevelDto) {
        LoyaltyCards loyaltyCards = MemberLevelMapper.INSTANCE.toEntity(memberLevelDto);
        setRelatedEntities(loyaltyCards,memberLevelDto.getTiersId());
        LoyaltyCards savedLoyaltyCards = memberLevelRepository.save(loyaltyCards);
        return MemberLevelMapper.INSTANCE.toResponseDto(savedLoyaltyCards);
    }

    private void setRelatedEntities(LoyaltyCards loyaltyCards,String tierId) {
        Tiers tiers = EntityFinder.findById(tierRepository, tierId, "Tier");
        logger.info("get tiers data: {}", tiers);
        loyaltyCards.setTiers(tiers);
    }
}
