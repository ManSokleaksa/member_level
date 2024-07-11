package com.member_level.member_level.service;

import com.member_level.member_level.dto.request.LanguageDto;

import java.util.List;

public interface LanguageService {
    List<LanguageDto> getAllLanguages();
    LanguageDto getLanguageById(int id);
    LanguageDto createLanguage(LanguageDto languageDto);
    LanguageDto updateLanguage(int id, LanguageDto languageDto);
    void deleteLanguage(int id);
}
