package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.LanguageDto;
import com.member_level.member_level.entity.Language;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T11:37:04+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDto toDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setCode( language.getCode() );
        languageDto.setName( language.getName() );
        languageDto.setStatus( language.getStatus() );
        languageDto.setIsDeleted( language.getIsDeleted() );

        return languageDto;
    }

    @Override
    public Language toEntity(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setCode( languageDto.getCode() );
        language.setName( languageDto.getName() );
        language.setIsDeleted( languageDto.getIsDeleted() );
        language.setStatus( languageDto.getStatus() );

        return language;
    }
}
