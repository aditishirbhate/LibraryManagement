package com.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    private String category;

    private String publisher;

    @Column(unique = true)
    private String isbn;

    @Min(value = 0)
    private Double price;

    @Min(value = 0)
    private Integer quantity;

    @Min(value = 0)
    @Column(name = "available_quantity")
    private Integer availableQuantity;
}