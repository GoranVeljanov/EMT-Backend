package mk.finki.ukim.labs.model;

import lombok.Data;
import mk.finki.ukim.labs.model.enumeration.Category;


import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
    public Book() {

    }
}
