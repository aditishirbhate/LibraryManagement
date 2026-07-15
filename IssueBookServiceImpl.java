package com.library.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.repository.BookRepository;
import com.library.repository.IssueBookRepository;
import com.library.service.IssueBookService;

@Service
public class IssueBookServiceImpl implements IssueBookService {

    private static final Logger logger =
            LoggerFactory.getLogger(IssueBookServiceImpl.class);

    private final IssueBookRepository issueRepo;
    private final BookRepository bookRepo;

    public IssueBookServiceImpl(IssueBookRepository issueRepo,
                                BookRepository bookRepo) {
        this.issueRepo = issueRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public IssueBook issueBook(IssueBook issueBook) {

        Book book = bookRepo.findById(issueBook.getBook().getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableQuantity() <= 0) {
            throw new RuntimeException("Book Not Available");
        }

        book.setAvailableQuantity(book.getAvailableQuantity() - 1);

        bookRepo.save(book);

        issueBook.setReturned(false);

        logger.info("Book Issued Successfully");

        return issueRepo.save(issueBook);
    }

    @Override
    public IssueBook returnBook(Integer issueId) {

        IssueBook issue = issueRepo.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue Record Not Found"));

        Book book = issue.getBook();

        book.setAvailableQuantity(book.getAvailableQuantity() + 1);

        issue.setReturned(true);

        bookRepo.save(book);

        logger.info("Book Returned Successfully");

        return issueRepo.save(issue);
    }

    @Override
    public List<IssueBook> getAllIssuedBooks() {
        return issueRepo.findAll();
    }

    @Override
    public List<IssueBook> getPendingBooks() {
        return issueRepo.findByReturnedFalse();
    }

}