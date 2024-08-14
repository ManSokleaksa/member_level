package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.dto.response.MemberLevelResponse;
import com.member_level.member_level.entity.LoyaltyCards;
import com.member_level.member_level.entity.Tiers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T15:34:21+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class MemberLevelMapperImpl implements MemberLevelMapper {

    @Override
    public LoyaltyCards toEntity(MemberLevelDto dto) {
        if ( dto == null ) {
            return null;
        }

        LoyaltyCards loyaltyCards = new LoyaltyCards();

        loyaltyCards.setCardNumber( dto.getCardNumber() );
        loyaltyCards.setBeans( dto.getBeans() );
        loyaltyCards.setTierStartDate( dto.getTierStartDate() );
        loyaltyCards.setTierExpireDate( dto.getTierExpireDate() );
        loyaltyCards.setCooperateStartDate( dto.getCooperateStartDate() );
        loyaltyCards.setCooperateEndDate( dto.getCooperateEndDate() );
        loyaltyCards.setStartDateFirstTopup( dto.getStartDateFirstTopup() );
        loyaltyCards.setEndDateFirstTopup( dto.getEndDateFirstTopup() );

        return loyaltyCards;
    }

    @Override
    public MemberLevelResponse toResponseDto(LoyaltyCards entity) {
        if ( entity == null ) {
            return null;
        }

        MemberLevelResponse memberLevelResponse = new MemberLevelResponse();

        memberLevelResponse.setTiersName( entityTiersName( entity ) );
        memberLevelResponse.setTiersId( entityTiersId( entity ) );
        memberLevelResponse.setId( entity.getId() );
        memberLevelResponse.setCardNumber( entity.getCardNumber() );
        memberLevelResponse.setBeans( entity.getBeans() );
        memberLevelResponse.setTierStartDate( entity.getTierStartDate() );
        memberLevelResponse.setTierExpireDate( entity.getTierExpireDate() );
        memberLevelResponse.setCooperateStartDate( entity.getCooperateStartDate() );
        memberLevelResponse.setCooperateEndDate( entity.getCooperateEndDate() );
        memberLevelResponse.setStartDateFirstTopup( entity.getStartDateFirstTopup() );
        memberLevelResponse.setEndDateFirstTopup( entity.getEndDateFirstTopup() );

        return memberLevelResponse;
    }

    private String entityTiersName(LoyaltyCards loyaltyCards) {
        if ( loyaltyCards == null ) {
            return null;
        }
        Tiers tiers = loyaltyCards.getTiers();
        if ( tiers == null ) {
            return null;
        }
        String name = tiers.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String entityTiersId(LoyaltyCards loyaltyCards) {
        if ( loyaltyCards == null ) {
            return null;
        }
        Tiers tiers = loyaltyCards.getTiers();
        if ( tiers == null ) {
            return null;
        }
        String id = tiers.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
