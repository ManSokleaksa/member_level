package com.member_level.member_level.repository;



import com.member_level.member_level.entity.MemberboxMessages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MemberboxMessagesRepository extends JpaRepository<MemberboxMessages, String> {
    // Method to find all languages where isDeleted is false
    List<MemberboxMessages> findByIsDeletedFalse();
}
