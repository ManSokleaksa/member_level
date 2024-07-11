package com.member_level.member_level.repository;

import com.member_level.member_level.entity.LoyaltyCards;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberLevelRepository extends JpaRepository<LoyaltyCards,Long> {

    @EntityGraph(attributePaths = "tiers")
    Optional<LoyaltyCards> findByCardNumber(@Param("cardNumber") String cardNumber);

}
