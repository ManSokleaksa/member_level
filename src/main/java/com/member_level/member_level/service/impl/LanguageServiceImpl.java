package com.member_level.member_level.service.impl;

import com.member_level.member_level.dto.request.LanguageDto;
import com.member_level.member_level.entity.Language;
import com.member_level.member_level.exception.ResourceNotFoundException;
import com.member_level.member_level.mapper.LanguageMapper;
import com.member_level.member_level.repository.LanguageRepository;
import com.member_level.member_level.service.LanguageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LanguageDto> getAllLanguages() {
        return languageRepository.findByIsDeletedFalse().stream()
                .map(LanguageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageDto getLanguageById(String id) {
        Language language = findLanguageById(id);
        return LanguageMapper.INSTANCE.toDto(language);
    }

    @Override
    @Transactional
    public LanguageDto createLanguage(LanguageDto languageDto) {
        Language language = LanguageMapper.INSTANCE.toEntity(languageDto);
        Language savedLanguage = languageRepository.save(language);
        return LanguageMapper.INSTANCE.toDto(savedLanguage);
    }

    @Override
    @Transactional
    public LanguageDto updateLanguage(String id, LanguageDto languageDto) {
        Language existingLanguage = findLanguageById(id);

        existingLanguage.setCode(languageDto.getCode());
        existingLanguage.setName(languageDto.getName());
        existingLanguage.setStatus(languageDto.getStatus());

        Language updatedLanguage = languageRepository.save(existingLanguage);
        return LanguageMapper.INSTANCE.toDto(updatedLanguage);
    }

    @Override
    @Transactional
    public void deleteLanguage(String id) {
        Language existingLanguage = findLanguageById(id);
        existingLanguage.setIsDeleted(true);
        languageRepository.save(existingLanguage);
    }

    private Language findLanguageById(String id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }
}
