package com.example.librarymanagmentapp.web;

import com.example.librarymanagmentapp.model.Book;
import com.example.librarymanagmentapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<Book> saveEmployee(@RequestBody Book book) {

        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public Set<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/find/title/{title}")
    public Optional<Book> findBookByTitle(@PathVariable String title) {
        return Optional.ofNullable(bookService.findByTitle(title));
    }

    @GetMapping("/find/subject/{subject}")
    public Optional<Book> findBookBySubject(@PathVariable String subject) {
        return Optional.ofNullable(bookService.findBySubject(subject));
    }

    @GetMapping("/find/format/{format}")
    public Optional<Book> findBookByFormat(@PathVariable String format) {
        return Optional.ofNullable(bookService.findByFormat(format));
    }

    @GetMapping("/find/author/{author}")
    public Optional<Book> findBookByAuthor(@PathVariable String author) {
        return Optional.ofNullable(bookService.FindBookByAuthor(author));
    }

    @GetMapping("/find/status/{status}")
    public Book findBookByStatus(@PathVariable String status) {
        return bookService.findBookByBookStatus(status);
    }

    @GetMapping("/find/isbn/{isbn}")
    public Book findBookByIsbn(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @PutMapping("/update/isbn/{isbn}")
    // ResponseEntity help with adding a body
    public ResponseEntity<Book> updateBook(@PathVariable("isbn") Long isbn,
                                           @RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.updateBook(book, isbn), HttpStatus.OK);
    }

    @DeleteMapping("/delete/isbn/{isbn}")
    public ResponseEntity<String> deleteBookIsbn(@PathVariable String isbn) {
        bookService.DeleteBookByIsbn(isbn);
        return new ResponseEntity<String>("Book deleted successfully", HttpStatus.OK);
    }

}
