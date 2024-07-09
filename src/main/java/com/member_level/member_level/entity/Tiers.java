package com.member_level.member_level.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tiers")
public class Tiers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bean_need", nullable = false)
    private int beanNeed;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

    @Column(name = "is_delete", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @OneToMany(mappedBy = "tiers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoyaltyCards> loyaltyCards;

}
