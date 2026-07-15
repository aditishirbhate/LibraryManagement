package com.library.service;

import java.util.List;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.Member;

public interface IssueBookService {

    // Issue Book
    IssueBook issueBook(IssueBook issueBook);

    // Return Book
    IssueBook returnBook(Integer issueId);

    // Delete Issue Record
    void deleteIssue(Integer issueId);

    // Get Issue By ID
    IssueBook getIssueById(Integer issueId);

    // Get All Issued Books
    List<IssueBook> getAllIssuedBooks();

    // Get Books Issued By Member
    List<IssueBook> getBooksByMember(Member member);

    // Get Issue Records By Book
    List<IssueBook> getIssueByBook(Book book);

    // Get By Status
    List<IssueBook> getByStatus(String status);

    // Get Member Issues By Status
    List<IssueBook> getMemberStatus(Member member, String status);
}