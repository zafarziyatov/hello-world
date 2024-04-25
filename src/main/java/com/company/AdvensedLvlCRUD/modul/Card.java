package com.company.AdvensedLvlCRUD.modul;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;
    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String cardFulName;

    @Column(nullable = false, unique = true)
    private String carCode;

    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private Integer userId;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
