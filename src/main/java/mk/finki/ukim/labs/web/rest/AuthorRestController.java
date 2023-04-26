package mk.finki.ukim.labs.web.rest;

import mk.finki.ukim.labs.model.Author;
import mk.finki.ukim.labs.model.dto.AuthorDto;
import mk.finki.ukim.labs.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAuthors(){
        return this.authorService.listAuthors();
    }
    @PostMapping("/add-author")
    public ResponseEntity<Author> create(@RequestBody AuthorDto authorDto) {
        return this.authorService.addAuthor(authorDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
