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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @UuidGenerator
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MemberboxMessages> memberBoxMessages;

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

