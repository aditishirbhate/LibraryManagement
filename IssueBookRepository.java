package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.IssueBook;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook, Integer> {

    List<IssueBook> findByReturnedFalse();

}