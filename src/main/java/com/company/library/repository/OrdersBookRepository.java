package com.company.library.repository;

import com.company.library.entity.OrdersBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OrdersBookRepository extends JpaRepository<OrdersBook,Integer> {
    Optional<OrdersBook> findByOrdersBookIdAndDeletedAtIsNull(Integer integer);
}
