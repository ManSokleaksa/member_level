package com.member_level.member_level.repository;

import com.member_level.member_level.entity.LoyaltyCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberLevelRepository extends JpaRepository<LoyaltyCards,Long> {
    @Query("SELECT lc FROM LoyaltyCards lc JOIN FETCH lc.tiers t WHERE lc.cardNumber = :cardNumber")
    LoyaltyCards findMemberLevelByCardNumber(@Param("cardNumber") String cardNumber);

}
