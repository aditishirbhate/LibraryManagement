package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Member;
import com.library.service.MemberService;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Add Member
    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    // Update Member
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Integer id,
                                               @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    // Delete Member
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member Deleted Successfully");
    }

    // Get Member By ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Integer id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    // Get All Members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    // Search Member By Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Member>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(memberService.searchByName(name));
    }

    // Find Member By Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.getMemberByEmail(email));
    }

    // Check Email Exists
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.existsByEmail(email));
    }

}