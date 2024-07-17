package com.member_level.member_level.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "memberbox_messages")
public class MemberboxMessages {
    @Id
    @UuidGenerator
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiers_id", nullable = false)
    private Tiers tiers;

    @Lob
    @Column(name = "message",nullable = false, columnDefinition = "TEXT")
    private String message;

    @Lob
    @Column(name = "term_and_condition",nullable = false, columnDefinition = "TEXT")
    private String termAndCondition;

    @Column(name = "message_over_bean", columnDefinition = "TEXT")
    private String messageOverBean;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = true;
        }
        if (isDeleted == null) {
            isDeleted = false;
        }
    }
}

