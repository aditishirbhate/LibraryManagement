package com.library.service;

import java.util.List;

import com.library.entity.Book;

public interface BookService {

    // Save Book
    Book saveBook(Book book);

    // Update Book
    Book updateBook(Integer id, Book book);

    // Delete Book
    void deleteBook(Integer id);

    // Get Book By ID
    Book getBookById(Integer id);

    // Get All Books
    List<Book> getAllBooks();

    // Search By Title
    List<Book> searchByTitle(String title);

    // Search By Author
    List<Book> searchByAuthor(String author);

    // Search By Category
    List<Book> searchByCategory(String category);

    // Find By ISBN
    Book getBookByIsbn(String isbn);

    // Get Available Books
    List<Book> getAvailableBooks();
}