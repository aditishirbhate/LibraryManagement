package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.Member;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook, Integer> {

    // Find books issued by a member
    List<IssueBook> findByMember(Member member);

    // Find issues for a book
    List<IssueBook> findByBook(Book book);

    // Find by status
    List<IssueBook> findByStatus(String status);

    // Find by member and status
    List<IssueBook> findByMemberAndStatus(Member member, String status);
}