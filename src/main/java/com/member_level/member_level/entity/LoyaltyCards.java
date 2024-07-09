package com.member_level.member_level.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loyalty_cards")
public class LoyaltyCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "tiers_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Tiers tiers;

    @Column(name = "tiers_id")
    private Integer tiersId;

    @Column(name = "cooperates_id")
    private Integer cooperatesId;

    @Column(name = "beans", nullable = false)
    private int beans;

    @Column(name = "tier_start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tierStartDate;

    @Column(name = "tier_expire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tierExpireDate;

    @Column(name = "cooperate_start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cooperateStartDate;

    @Column(name = "cooperate_end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cooperateEndDate;

    @Column(name = "start_date_first_topup")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDateFirstTopup;

    @Column(name = "end_date_first_topup")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDateFirstTopup;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
}
