package com.example.librarymanagmentapp.service.serviceImplementation;

import com.example.librarymanagmentapp.exception.ResourceNotFoundException;
import com.example.librarymanagmentapp.model.Book;
import com.example.librarymanagmentapp.repository.BookRepository;
import com.example.librarymanagmentapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookJpaService implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public Set<Book> getAllBooks() {
        Set<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
    @Override
    public Book findByTitle(String title) {
        return bookRepository.findBookByTitleIgnoreCase(title);
    }

    @Override
    public Book findBySubject(String subject) {
        return bookRepository.findBookBySubject(subject);
    }

    @Override
    public Book findByFormat(String format) {
        return bookRepository.findBookByBookFormat(format);
    }

    @Override
    public Book FindBookByAuthor(String author) {
        return bookRepository.findBookByAuthorsIgnoreCase(author);
    }

    @Override
    public Book findBookByBookStatus(String status) {
        return bookRepository.findBookByBookStatus(status);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByISBN(isbn);
    }

    @Override
    public Book updateBook(Book book, Long isbn) {

        Book existingBook = bookRepository.findById(isbn).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", isbn));
        existingBook.setAuthors(book.getAuthors());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setBookFormat(book.getBookFormat());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setSubject(book.getSubject());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setTitle(book.getTitle());
        existingBook.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public void DeleteBookByIsbn(String isbn) {
        Book book= bookRepository.findBookByTitleIgnoreCase(isbn);
        if(book.getTitle().isEmpty()){
            throw new ResourceNotFoundException("Book","title",isbn);
        }
//        System.out.println("Are you sure you want to delete a book with: " + isbn
//        because this action can not be undone);
//        Scanner sc=new Scanner(System.in);
//        String delete= sc.nextLine();
//        if(delete =="Ok"){
//            bookRepository.delete(book);
//        }
        bookRepository.delete(book);
    }

}
