package com.company.library.repository;

import com.company.library.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
    Optional<Goal> findByGoalIdAndDeletedAtIsNull(Integer goalId);

}
