package com.exam.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "_books")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String author;
    private String publisher;
    private LocalDate publicationDate;
    private String subject;
}
