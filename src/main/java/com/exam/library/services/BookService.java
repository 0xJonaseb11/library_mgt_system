package com.exam.library.services;

import com.exam.library.models.Book;
import com.exam.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Page<Book> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Book getBookById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Integer id) {
        repository.deleteById(id);
    }

    public Page<Book> searchBooks(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByNameContainingOrAuthorContainingOrPublisherContainingOrSubjectContaining(
                keyword, keyword, keyword, keyword, pageable);
    }
}
