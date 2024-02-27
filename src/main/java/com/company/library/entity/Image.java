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
@Table(name = "images")
public class Image {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;
    private String path;
    private String type;
    private String size;
    private String token;

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
