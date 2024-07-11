package com.member_level.member_level.mapper;


import com.member_level.member_level.dto.request.LanguageDto;
import com.member_level.member_level.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    LanguageDto toDto(Language language);
    Language toEntity(LanguageDto languageDto);
}
