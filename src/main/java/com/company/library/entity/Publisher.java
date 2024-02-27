package com.company.library.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publishers")
public class Publisher {

    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    private String publisher;
    private String location;

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
