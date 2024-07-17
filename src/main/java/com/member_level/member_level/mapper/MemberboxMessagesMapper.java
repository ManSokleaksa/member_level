package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.MemberboxMessagesDto;
import com.member_level.member_level.entity.MemberboxMessages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberboxMessagesMapper {
    MemberboxMessagesMapper INSTANCE = Mappers.getMapper(MemberboxMessagesMapper.class);

    @Mapping(target = "language.id", source = "languageId")
    @Mapping(target = "tiers.id", source = "tiersId")
    MemberboxMessages toEntity(MemberboxMessagesDto dto);

    @Mapping(target = "languageId", source = "language.id")
    @Mapping(target = "tiersId", source = "tiers.id")
    MemberboxMessagesDto toDto(MemberboxMessages entity);
}
