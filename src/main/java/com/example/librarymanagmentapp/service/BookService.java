package com.example.librarymanagmentapp.service;

import com.example.librarymanagmentapp.model.Book;

import java.util.Set;

public interface BookService {
    Book saveBook(Book book);
    Set<Book> getAllBooks();
    Book findByTitle(String title);
    Book findBySubject(String subject);
    Book findByFormat(String format);
    Book FindBookByAuthor(String author);
    Book  findBookByBookStatus(String status);
    Book findBookByIsbn(String isbn);
    Book updateBook(Book book, Long isbn);
    void DeleteBookByIsbn(String isbn);
}
