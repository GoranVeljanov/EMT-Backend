package mk.finki.ukim.labs.model.dto;

import lombok.Data;
import mk.finki.ukim.labs.model.Country;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Country country;
}
