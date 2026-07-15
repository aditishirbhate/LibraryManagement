package com.library.service;

import java.util.List;

import com.library.entity.IssueBook;

public interface IssueBookService {

    IssueBook issueBook(IssueBook issueBook);

    IssueBook returnBook(Integer issueId);

    List<IssueBook> getAllIssuedBooks();

    List<IssueBook> getPendingBooks();

}