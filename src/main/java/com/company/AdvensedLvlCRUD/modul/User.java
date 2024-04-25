package com.company.AdvensedLvlCRUD.modul;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;
    private String password;

    @Column(nullable = false)
    private Integer age;


    @OneToMany(mappedBy = "userId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Card> cards;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


}
