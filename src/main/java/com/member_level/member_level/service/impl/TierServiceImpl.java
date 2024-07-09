package com.member_level.member_level.service.impl;

import com.member_level.member_level.dto.request.TierDto;
import com.member_level.member_level.entity.Tiers;
import com.member_level.member_level.mapper.TierMapper;
import com.member_level.member_level.repository.TierRepository;
import com.member_level.member_level.service.TierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TierServiceImpl implements TierService {
    private final TierRepository tierRepository;

    public TierServiceImpl(TierRepository tierRepository) {
        this.tierRepository = tierRepository;
    }

    @Override
    public List<TierDto> getAllTiers() {
        List<Tiers> tiers = tierRepository.findAll();
        List<TierDto> tierDtos = tiers.stream()
                .map(TierMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return tierDtos;
    }

    @Override
    public TierDto createTier(TierDto tierDto) {
        Tiers tiers = TierMapper.INSTANCE.toEntity(tierDto);
        Tiers savedTier = tierRepository.save(tiers);
        return TierMapper.INSTANCE.toDto(savedTier);
    }


}
