package com.company.library.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String username;
    private Integer genderId;
    private String phone;
    private String password;
    private Integer cardId;
    private LocalDate birthDate;

    private boolean enabled;

    @OneToMany(mappedBy = "username",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Authorities>authorities;

    @OneToOne
    @JoinColumn(name = "genderId", referencedColumnName = "gender_id", insertable = false, updatable = false)
    private Gender gender;

    @OneToMany(mappedBy = "userId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "userId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Orders> orders;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


}


