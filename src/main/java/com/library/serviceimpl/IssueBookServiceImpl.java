package com.library.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.Member;
import com.library.repository.BookRepository;
import com.library.repository.IssueBookRepository;
import com.library.service.IssueBookService;

@Service
public class IssueBookServiceImpl implements IssueBookService {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public IssueBook issueBook(IssueBook issueBook) {

        Book book = issueBook.getBook();

        if (book.getAvailableQuantity() <= 0) {
            throw new RuntimeException("Book is not available");
        }

        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
        bookRepository.save(book);

        issueBook.setIssueDate(LocalDate.now());
        issueBook.setStatus("ISSUED");

        return issueBookRepository.save(issueBook);
    }

    @Override
    public IssueBook returnBook(Integer issueId) {

        IssueBook issueBook = issueBookRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue Record Not Found"));

        issueBook.setReturnDate(LocalDate.now());
        issueBook.setStatus("RETURNED");

        Book book = issueBook.getBook();

        book.setAvailableQuantity(book.getAvailableQuantity() + 1);

        bookRepository.save(book);

        return issueBookRepository.save(issueBook);
    }

    @Override
    public void deleteIssue(Integer issueId) {
        issueBookRepository.deleteById(issueId);
    }

    @Override
    public IssueBook getIssueById(Integer issueId) {
        return issueBookRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue Record Not Found"));
    }

    @Override
    public List<IssueBook> getAllIssuedBooks() {
        return issueBookRepository.findAll();
    }

    @Override
    public List<IssueBook> getBooksByMember(Member member) {
        return issueBookRepository.findByMember(member);
    }

    @Override
    public List<IssueBook> getIssueByBook(Book book) {
        return issueBookRepository.findByBook(book);
    }

    @Override
    public List<IssueBook> getByStatus(String status) {
        return issueBookRepository.findByStatus(status);
    }

    @Override
    public List<IssueBook> getMemberStatus(Member member, String status) {
        return issueBookRepository.findByMemberAndStatus(member, status);
    }

}