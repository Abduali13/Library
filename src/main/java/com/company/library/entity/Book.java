package com.company.library.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "goal_id")
    private Integer goalId;

    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "publisher_id")
    private Integer publisherId;

    private Float price;
    private Integer page;
    private LocalDate published;
    private Float amount;

    @Column(name = "orders_book_id")
    private Integer ordersBookId;

    @OneToOne
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "author_id",
            insertable = false,
            updatable = false)
    private Author author;

    @OneToOne
    @JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id",insertable = false, updatable = false)
    private Publisher publisher;

    @OneToOne
    @JoinColumn(name = "image_id",referencedColumnName = "image_id",insertable = false, updatable = false)
    private Image image;

    @OneToMany(mappedBy = "goalId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Goal> goals;


    @ManyToOne
    @JoinColumn(name = "orders_book_id", insertable = false, updatable = false)
    private OrdersBook ordersBooks;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
