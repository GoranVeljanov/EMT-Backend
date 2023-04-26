package mk.finki.ukim.labs.service.Impl;

import mk.finki.ukim.labs.model.Author;
import mk.finki.ukim.labs.model.Book;
import mk.finki.ukim.labs.model.dto.AuthorDto;
import mk.finki.ukim.labs.model.dto.BookDto;
import mk.finki.ukim.labs.repository.AuthorRepository;
import mk.finki.ukim.labs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> addAuthor(AuthorDto authorDto) {
        return Optional.of(this.authorRepository.save(new Author(authorDto.getName(),authorDto.getSurname(),authorDto.getCountry())));
    }

}
