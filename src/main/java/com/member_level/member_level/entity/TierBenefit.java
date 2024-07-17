package com.member_level.member_level.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tier_benefit")
public class TierBenefit {
    @Id
    @UuidGenerator
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String id;

    @ManyToOne
    @JoinColumn(name = "tiers_id")
    private Tiers tiers;

    @Column(name = "minimum_topup_amount", nullable = false)
    private int minimumTopupAmount;

    @Column(name = "bonus_point", nullable = false)
    private int bonusPoint;

    @Column(name = "bonus_percent", nullable = false)
    private int bonusPercent;

    @Column(name = "bonus_amount", nullable = false)
    private int bonusAmount;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "benefit_type", nullable = false)
    private BenefitType benefitType;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public enum BenefitType {
        DISCOUNT,
        CASHBACK,
        POINTS
    }
}
