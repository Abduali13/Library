package com.company.library.repository;

import com.company.library.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    Optional<Orders> findByOrderIdAndDeletedAtIsNull(Integer integer);

}
