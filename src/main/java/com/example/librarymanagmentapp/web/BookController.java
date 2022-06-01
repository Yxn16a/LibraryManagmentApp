package com.example.librarymanagmentapp.web;

import com.example.librarymanagmentapp.model.Book;
import com.example.librarymanagmentapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/book/api/v1/books")
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('book:write')")
    public ResponseEntity<Book> saveEmployee(@RequestBody Book book) {

        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_LIBRARYUSER','ROLE_LIBRARIAN')")
    public Set<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/find/title/{title}")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_LIBRARYUSER','ROLE_LIBRARIAN')")
    public Optional<Book> findBookByTitle(@PathVariable("title") String title) {
        return Optional.ofNullable(bookService.findByTitle(title));
    }

    @GetMapping("/find/subject/{subject}")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_LIBRARYUSER','ROLE_LIBRARIAN')")
    public Optional<Book> findBookBySubject(@PathVariable("subject") String subject) {
        return Optional.ofNullable(bookService.findBySubject(subject));
    }

    @GetMapping("/find/format/{format}")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_LIBRARYUSER','ROLE_LIBRARIAN')")
    public Optional<Book> findBookByFormat(@PathVariable("format") String format) {
        return Optional.ofNullable(bookService.findByFormat(format));
    }

    @GetMapping("/find/author/{author}")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_LIBRARYUSER','ROLE_LIBRARIAN')")
    public Optional<Book> findBookByAuthor(@PathVariable("author") String author) {
        return Optional.ofNullable(bookService.FindBookByAuthor(author));
    }

    @GetMapping("/find/status/{status}")
    public Book findBookByStatus(@PathVariable("status") String status) {
        return bookService.findBookByBookStatus(status);
    }

    @GetMapping("/find/isbn/{isbn}")
    public Book findBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @PutMapping("/update/isbn/{isbn}")
    // ResponseEntity help with adding a body
    public ResponseEntity<Book> updateBook(@PathVariable("isbn") Long isbn,
                                           @RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.updateBook(book, isbn), HttpStatus.OK);
    }
    // fix validation in service when a wrong isbn is passed
    @DeleteMapping("/delete/isbn/{isbn}")
    public ResponseEntity<String> deleteBookIsbn(@PathVariable("isbn") String isbn) {
        bookService.DeleteBookByIsbn(isbn);
        return new ResponseEntity<String>("Book deleted successfully", HttpStatus.OK);
    }

}
