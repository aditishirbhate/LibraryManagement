package com.library.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger =
            LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {

        logger.info("Saving book : {}", book.getTitle());

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new RuntimeException("Book with this ISBN already exists.");
        }

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book book) {

        Book existing = getBookById(id);

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setCategory(book.getCategory());
        existing.setPublisher(book.getPublisher());
        existing.setPrice(book.getPrice());
        existing.setQuantity(book.getQuantity());
        existing.setAvailableQuantity(book.getAvailableQuantity());

        logger.info("Updating book id {}", id);

        return bookRepository.save(existing);
    }

    @Override
    public void deleteBook(Integer id) {

        logger.info("Deleting book id {}", id);

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
    public Book searchByIsbn(String isbn) {

        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

}