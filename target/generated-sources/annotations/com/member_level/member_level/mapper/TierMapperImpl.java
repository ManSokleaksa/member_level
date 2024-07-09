package com.member_level.member_level.mapper;

import com.member_level.member_level.dto.request.TierDto;
import com.member_level.member_level.entity.Tiers;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-09T14:23:23+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class TierMapperImpl implements TierMapper {

    @Override
    public Tiers toEntity(TierDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tiers tiers = new Tiers();

        tiers.setName( dto.getName() );
        tiers.setBeanNeed( dto.getBeanNeed() );
        tiers.setLevel( dto.getLevel() );

        return tiers;
    }

    @Override
    public TierDto toDto(Tiers entity) {
        if ( entity == null ) {
            return null;
        }

        TierDto tierDto = new TierDto();

        tierDto.setName( entity.getName() );
        tierDto.setBeanNeed( entity.getBeanNeed() );
        tierDto.setLevel( entity.getLevel() );

        return tierDto;
    }
}
