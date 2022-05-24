package com.example.librarymanagmentapp.service.serviceImplementation;

import com.example.librarymanagmentapp.exception.ResourceNotFoundException;
import com.example.librarymanagmentapp.model.Book;
import com.example.librarymanagmentapp.model.BookFormat;
import com.example.librarymanagmentapp.repository.BookRepository;
import com.example.librarymanagmentapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookJpaService implements BookService {
    private final BookRepository bookRepository;
    private String removeSpace(String spacedString){
        String trimString = spacedString.trim();
        String removeSpaces = trimString.replaceAll("\\s+","");
        return removeSpaces;
    }
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
        String subjectToLowerCase = subject.toLowerCase();
        return bookRepository.findBookBySubject(removeSpace(subjectToLowerCase));
    }
       // **problems with book format enums posting and retrieving
    // **search how to make string be enums
    @Override
    public Book findByFormat(String format) {
        String formatToLowerCase = format.toUpperCase();
        return bookRepository.findBookByBookFormat(removeSpace(formatToLowerCase));
    }
        // Work with author first and last name and other author fields
        // be explicit about it
    @Override
    public Book FindBookByAuthor(String author) {
        String authorToLowerCase = author.toLowerCase();
        return bookRepository.findBookByAuthors(removeSpace(authorToLowerCase));
    }

    @Override
    public Book findBookByBookStatus(String status) {
        return bookRepository.findBookByBookStatus(status);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbnIgnoreCase(isbn);
    }

    @Override
    public Book updateBook(Book book, Long isbn) {

        Book existingBook = bookRepository.findById(isbn).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", isbn));
        existingBook.setTitle(book.getTitle());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setPublicationDate(book.getPublicationDate());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setNumberOfPages(book.getNumberOfPages());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setSubject(book.getSubject());
        existingBook.setBarCode(book.getBarCode());
        existingBook.setBookFormat(book.getBookFormat());
        existingBook.setBookItem(book.getBookItem());
        existingBook.setAccount(book.getAccount());
        existingBook.setBookStatus(book.getBookStatus());
        existingBook.setAuthors(book.getAuthors());
        existingBook.setRack(book.getRack());
        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public void DeleteBookByIsbn(String isbn) {
        Book book= bookRepository.findBookByIsbnIgnoreCase(isbn);
        if(book.getIsbn().isEmpty()){
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
