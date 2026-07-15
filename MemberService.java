package com.library.service;

import java.util.List;

import com.library.entity.Member;

public interface MemberService {

    // Save Member
    Member saveMember(Member member);

    // Update Member
    Member updateMember(Integer id, Member member);

    // Delete Member
    void deleteMember(Integer id);

    // Get Member By ID
    Member getMemberById(Integer id);

    // Get All Members
    List<Member> getAllMembers();

    // Find By Email
    Member getMemberByEmail(String email);

    // Search By Name
    List<Member> searchByName(String name);

    // Check Email Exists
    boolean existsByEmail(String email);
}