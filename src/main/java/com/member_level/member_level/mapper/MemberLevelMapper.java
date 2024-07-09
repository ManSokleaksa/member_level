package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.MemberLevelDto;
import com.member_level.member_level.entity.LoyaltyCards;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberLevelMapper {
    MemberLevelMapper INSTANCE = Mappers.getMapper(MemberLevelMapper.class);

    @Mapping(target = "id", ignore = true) // Ignoring id field
    @Mapping(target = "createdAt", ignore = true) // Ignoring createdAt field
    @Mapping(target = "updatedAt", ignore = true) // Ignoring updatedAt field
    @Mapping(target = "isDeleted", ignore = true) // Ignoring isDeleted field
    @Mapping(target = "status", ignore = true) // Ignoring status field
    LoyaltyCards toEntity(MemberLevelDto dto);
    
    @Mapping(source = "tiers.name", target = "tiersName")
    MemberLevelDto toDto(LoyaltyCards entity);
}
