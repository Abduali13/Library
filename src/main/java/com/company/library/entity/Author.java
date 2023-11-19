package com.company.library.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
    private Integer authorAge;

    @Column(name = "book_id")
    private Integer bookId;

    @OneToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "book_id",
            insertable = false,
            updatable = false)
    private Book book;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
