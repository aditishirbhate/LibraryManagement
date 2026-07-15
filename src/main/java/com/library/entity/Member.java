package com.library.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Enter valid email")
    @Column(unique = true)
    private String email;

    private String mobile;

    private String address;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<IssueBook> issuedBooks;
}