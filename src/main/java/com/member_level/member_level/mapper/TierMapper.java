package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.TierDto;
import com.member_level.member_level.entity.Tiers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TierMapper {
    TierMapper INSTANCE = Mappers.getMapper(TierMapper.class);

    @Mapping(target = "id", ignore = true) // Ignoring id field
    @Mapping(target = "createdAt", ignore = true) // Ignoring createdAt field
    @Mapping(target = "updatedAt", ignore = true) // Ignoring updatedAt field
    @Mapping(target = "isDeleted", ignore = true) // Ignoring isDeleted field
    @Mapping(target = "status", ignore = true) // Ignoring status field
    Tiers toEntity(TierDto dto);

    TierDto toDto(Tiers entity);
}
