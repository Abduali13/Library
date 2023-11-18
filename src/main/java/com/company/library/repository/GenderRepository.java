package com.company.library.repository;

import com.company.library.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface GenderRepository extends JpaRepository<Gender,Integer> {
    Optional<Gender> findByGenderId(Integer integer);
}
