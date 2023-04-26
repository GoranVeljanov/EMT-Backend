package mk.finki.ukim.labs.service;

import mk.finki.ukim.labs.model.Author;
import mk.finki.ukim.labs.model.Book;
import mk.finki.ukim.labs.model.dto.BookDto;
import mk.finki.ukim.labs.model.enumeration.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAllBooks();
    Optional<Book> findById(Long id);
    Page<Book> listBooksPaginated(Pageable pageable);
    Optional<Book> create(BookDto bookDto);
    Optional<Book> update(Long id, BookDto bookDto);
    void deleteById(Long id);
    Optional<Book> markAsTaken(Long id);
}
