package com.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book book) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id : " + id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        existingBook.setQuantity(book.getQuantity());
        existingBook.setAvailableQuantity(book.getAvailableQuantity());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> searchByCategory(String category) {
        return bookRepository.findByCategoryContainingIgnoreCase(category);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableQuantityGreaterThan(0);
    }

}