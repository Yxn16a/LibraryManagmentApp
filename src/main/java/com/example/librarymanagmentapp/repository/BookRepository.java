package com.example.librarymanagmentapp.repository;

import com.example.librarymanagmentapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

    Book findBookByAuthors(String author);
    Book findBookByTitleIgnoreCase(String title);
    Book findBookByPublisher(String publisher);
    Book findBookBySubject(String subject);
    Book findBookByIsbnIgnoreCase(String isbn);
    Book findBookByBookFormat(String bookcoverformat);
    Book findBookByBookStatus(String status);
    void deleteBookByIsbn(String isbn);

}
