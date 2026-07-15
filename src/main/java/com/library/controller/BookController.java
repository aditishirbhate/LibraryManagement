package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    // Add Book
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    // Update Book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id,
                                           @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book Deleted Successfully");
    }

    // Get Book By Id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // Get All Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Search By Title
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    // Search By Author
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }

    // Search By Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> searchByCategory(@PathVariable String category) {
        return ResponseEntity.ok(bookService.searchByCategory(category));
    }

    // Get Book By ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }

    // Available Books
    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }

}