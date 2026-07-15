package com.library.service;

import java.util.List;

import com.library.entity.Book;

public interface BookService {

    Book saveBook(Book book);

    Book updateBook(Integer id, Book book);

    void deleteBook(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBooks();

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> searchByCategory(String category);

    Book searchByIsbn(String isbn);

}