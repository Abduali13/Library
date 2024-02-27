package com.company.library.repository;

import com.company.library.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer cardId);

}
