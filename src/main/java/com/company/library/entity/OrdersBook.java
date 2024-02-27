package com.company.library.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordersbook")
public class OrdersBook {

    @Id
    @Column(name = "orders_book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersBookId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders orders;

    @OneToMany(mappedBy = "bookId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
