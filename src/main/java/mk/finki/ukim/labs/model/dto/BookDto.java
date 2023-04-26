package mk.finki.ukim.labs.model.dto;

import lombok.Data;
import mk.finki.ukim.labs.model.enumeration.Category;

@Data
public class BookDto {
    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;
}
