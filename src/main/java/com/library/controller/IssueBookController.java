package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.entity.IssueBook;
import com.library.entity.Member;
import com.library.service.IssueBookService;

@RestController
@RequestMapping("/issues")
@CrossOrigin(origins = "*")
public class IssueBookController {

    @Autowired
    private IssueBookService issueBookService;

    // Issue Book
    @PostMapping
    public ResponseEntity<IssueBook> issueBook(@RequestBody IssueBook issueBook) {
        return ResponseEntity.ok(issueBookService.issueBook(issueBook));
    }

    // Return Book
    @PutMapping("/return/{id}")
    public ResponseEntity<IssueBook> returnBook(@PathVariable Integer id) {
        return ResponseEntity.ok(issueBookService.returnBook(id));
    }

    // Delete Issue Record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIssue(@PathVariable Integer id) {
        issueBookService.deleteIssue(id);
        return ResponseEntity.ok("Issue Record Deleted Successfully");
    }

    // Get Issue By ID
    @GetMapping("/{id}")
    public ResponseEntity<IssueBook> getIssueById(@PathVariable Integer id) {
        return ResponseEntity.ok(issueBookService.getIssueById(id));
    }

    // Get All Issued Books
    @GetMapping
    public ResponseEntity<List<IssueBook>> getAllIssuedBooks() {
        return ResponseEntity.ok(issueBookService.getAllIssuedBooks());
    }

    // Get Books By Member
    @PostMapping("/member")
    public ResponseEntity<List<IssueBook>> getBooksByMember(@RequestBody Member member) {
        return ResponseEntity.ok(issueBookService.getBooksByMember(member));
    }

    // Get Issue By Book
    @PostMapping("/book")
    public ResponseEntity<List<IssueBook>> getIssueByBook(@RequestBody Book book) {
        return ResponseEntity.ok(issueBookService.getIssueByBook(book));
    }

    // Get Issues By Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<IssueBook>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(issueBookService.getByStatus(status));
    }

    // Get Member Issues By Status
    @PostMapping("/member/status/{status}")
    public ResponseEntity<List<IssueBook>> getMemberStatus(
            @RequestBody Member member,
            @PathVariable String status) {

        return ResponseEntity.ok(issueBookService.getMemberStatus(member, status));
    }

}