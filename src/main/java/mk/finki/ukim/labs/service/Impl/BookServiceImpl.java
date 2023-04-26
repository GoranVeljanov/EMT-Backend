package mk.finki.ukim.labs.service.Impl;

import mk.finki.ukim.labs.model.Author;
import mk.finki.ukim.labs.model.Book;
import mk.finki.ukim.labs.model.dto.BookDto;
import mk.finki.ukim.labs.model.enumeration.Category;
import mk.finki.ukim.labs.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.labs.model.exceptions.BookNotFoundException;
import mk.finki.ukim.labs.repository.AuthorRepository;
import mk.finki.ukim.labs.repository.BookRepository;
import mk.finki.ukim.labs.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return this.bookRepository.findAll();
    }
    @Override
    public Page<Book> listBooksPaginated(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }
    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = (Author) this.authorRepository.findById(bookDto.getAuthor())
                .orElse(null);
        return Optional.of(this.bookRepository
                .save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = (Author) this.authorRepository.findById(bookDto.getAuthor()).orElse(null);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        int numOfCopies;
        if (book.getAvailableCopies() > 0) {
            numOfCopies = book.getAvailableCopies() - 1;
        } else {
            numOfCopies = book.getAvailableCopies();
        }

        book.setAvailableCopies(numOfCopies);
        return Optional.of(this.bookRepository.save(book));
    }
}
