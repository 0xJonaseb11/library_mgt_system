package com.exam.library.repositories;

import com.exam.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookRepository extends JpaRepository<Book , Integer> {
    Page<Book> findByNameContainingOrAuthorContainingOrPublisherContainingOrSubjectContaining(
            String name, String author, String publisher, String subject, Pageable pageable);
}
