package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.LanguageDto;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getAllLanguages();
    LanguageDto getLanguageById(String id);
    LanguageDto createLanguage(LanguageDto languageDto);
    LanguageDto updateLanguage(String id, LanguageDto languageDto);
    void deleteLanguage(String id);
}
