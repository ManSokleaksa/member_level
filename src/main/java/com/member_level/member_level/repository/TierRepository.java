package com.member_level.member_level.repository;

import com.member_level.member_level.entity.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TierRepository extends JpaRepository<Tiers, String> {
}
