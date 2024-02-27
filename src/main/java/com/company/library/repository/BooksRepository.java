package com.company.library.repository;

import com.company.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByBookId(Integer id);

    //List<Book> findAllByDeletedAtIsNull(Integer id);

}
