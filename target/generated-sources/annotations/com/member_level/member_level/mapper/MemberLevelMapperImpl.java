package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.entity.LoyaltyCards;
import com.member_level.member_level.entity.Tiers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T14:23:23+0700",
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
        loyaltyCards.setTiersId( dto.getTiersId() );
        loyaltyCards.setCooperatesId( dto.getCooperatesId() );
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
    public MemberLevelDto toDto(LoyaltyCards entity) {
        if ( entity == null ) {
            return null;
        }

        MemberLevelDto memberLevelDto = new MemberLevelDto();

        memberLevelDto.setTiersName( entityTiersName( entity ) );
        memberLevelDto.setCardNumber( entity.getCardNumber() );
        memberLevelDto.setTiersId( entity.getTiersId() );
        memberLevelDto.setCooperatesId( entity.getCooperatesId() );
        memberLevelDto.setBeans( entity.getBeans() );
        memberLevelDto.setTierStartDate( entity.getTierStartDate() );
        memberLevelDto.setTierExpireDate( entity.getTierExpireDate() );
        memberLevelDto.setCooperateStartDate( entity.getCooperateStartDate() );
        memberLevelDto.setCooperateEndDate( entity.getCooperateEndDate() );
        memberLevelDto.setStartDateFirstTopup( entity.getStartDateFirstTopup() );
        memberLevelDto.setEndDateFirstTopup( entity.getEndDateFirstTopup() );

        return memberLevelDto;
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
}
