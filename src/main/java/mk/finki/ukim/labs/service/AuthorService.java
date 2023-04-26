package mk.finki.ukim.labs.service;

import mk.finki.ukim.labs.model.Author;
import mk.finki.ukim.labs.model.dto.AuthorDto;


import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> addAuthor(AuthorDto authorDto);
}
