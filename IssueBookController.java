package com.library.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.entity.IssueBook;
import com.library.service.IssueBookService;

@RestController
@RequestMapping("/issue")
@CrossOrigin("*")
public class IssueBookController {

    private final IssueBookService issueService;

    public IssueBookController(IssueBookService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<?> issueBook(@Valid @RequestBody IssueBook issueBook) {

        try {

            return ResponseEntity.ok(issueService.issueBook(issueBook));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @PutMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Integer id) {

        try {

            return ResponseEntity.ok(issueService.returnBook(id));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @GetMapping
    public ResponseEntity<List<IssueBook>> getAllIssuedBooks() {

        return ResponseEntity.ok(issueService.getAllIssuedBooks());

    }

    @GetMapping("/pending")
    public ResponseEntity<List<IssueBook>> getPendingBooks() {

        return ResponseEntity.ok(issueService.getPendingBooks());

    }

}