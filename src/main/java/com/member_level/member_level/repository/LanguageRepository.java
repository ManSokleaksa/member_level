package com.member_level.member_level.repository;

import com.member_level.member_level.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    // Method to find all languages where isDeleted is false
    List<Language> findByIsDeletedFalse();
}
