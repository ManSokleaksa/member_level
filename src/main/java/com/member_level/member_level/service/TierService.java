package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.TierDto;
import java.util.List;
public interface TierService {
    TierDto createTier(TierDto tierDto);

    List<TierDto> getAllTiers();
}
