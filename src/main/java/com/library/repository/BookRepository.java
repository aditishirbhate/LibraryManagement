package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Search books by title
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Search books by author
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Search books by category
    List<Book> findByCategoryContainingIgnoreCase(String category);

    // Find by ISBN
    Book findByIsbn(String isbn);

    // Available books
    List<Book> findByAvailableQuantityGreaterThan(Integer quantity);
}