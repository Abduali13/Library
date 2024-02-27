package com.company.library.repository;

import com.company.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByAuthorIdAndDeletedAtIsNull(Integer authorId);

    List<Author> findAllByDeletedAtIsNull();

    //TODO: 1: method query
    //TODO: 2: native query
    //TODO: 3: HQL -> Hibernate Query Language
    //TODO: 4: Named Query

}
