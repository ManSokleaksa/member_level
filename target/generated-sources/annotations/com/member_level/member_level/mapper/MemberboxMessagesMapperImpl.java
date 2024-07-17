package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.MemberboxMessagesDto;
import com.member_level.member_level.entity.Language;
import com.member_level.member_level.entity.MemberboxMessages;
import com.member_level.member_level.entity.Tiers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-17T11:26:15+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class MemberboxMessagesMapperImpl implements MemberboxMessagesMapper {

    @Override
    public MemberboxMessages toEntity(MemberboxMessagesDto dto) {
        if ( dto == null ) {
            return null;
        }

        MemberboxMessages memberboxMessages = new MemberboxMessages();

        memberboxMessages.setLanguage( memberboxMessagesDtoToLanguage( dto ) );
        memberboxMessages.setTiers( memberboxMessagesDtoToTiers( dto ) );
        memberboxMessages.setMessage( dto.getMessage() );
        memberboxMessages.setTermAndCondition( dto.getTermAndCondition() );
        memberboxMessages.setMessageOverBean( dto.getMessageOverBean() );
        memberboxMessages.setIsDeleted( dto.getIsDeleted() );
        memberboxMessages.setStatus( dto.getStatus() );

        return memberboxMessages;
    }

    @Override
    public MemberboxMessagesDto toDto(MemberboxMessages entity) {
        if ( entity == null ) {
            return null;
        }

        MemberboxMessagesDto memberboxMessagesDto = new MemberboxMessagesDto();

        memberboxMessagesDto.setLanguageId( entityLanguageId( entity ) );
        memberboxMessagesDto.setTiersId( entityTiersId( entity ) );
        memberboxMessagesDto.setMessage( entity.getMessage() );
        memberboxMessagesDto.setTermAndCondition( entity.getTermAndCondition() );
        memberboxMessagesDto.setMessageOverBean( entity.getMessageOverBean() );
        memberboxMessagesDto.setIsDeleted( entity.getIsDeleted() );
        memberboxMessagesDto.setStatus( entity.getStatus() );

        return memberboxMessagesDto;
    }

    protected Language memberboxMessagesDtoToLanguage(MemberboxMessagesDto memberboxMessagesDto) {
        if ( memberboxMessagesDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setId( memberboxMessagesDto.getLanguageId() );

        return language;
    }

    protected Tiers memberboxMessagesDtoToTiers(MemberboxMessagesDto memberboxMessagesDto) {
        if ( memberboxMessagesDto == null ) {
            return null;
        }

        Tiers tiers = new Tiers();

        tiers.setId( memberboxMessagesDto.getTiersId() );

        return tiers;
    }

    private String entityLanguageId(MemberboxMessages memberboxMessages) {
        if ( memberboxMessages == null ) {
            return null;
        }
        Language language = memberboxMessages.getLanguage();
        if ( language == null ) {
            return null;
        }
        String id = language.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityTiersId(MemberboxMessages memberboxMessages) {
        if ( memberboxMessages == null ) {
            return null;
        }
        Tiers tiers = memberboxMessages.getTiers();
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
