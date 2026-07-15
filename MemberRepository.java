package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    // Find by email
    Member findByEmail(String email);

    // Search by name
    List<Member> findByNameContainingIgnoreCase(String name);

    // Check email already exists
    boolean existsByEmail(String email);
}