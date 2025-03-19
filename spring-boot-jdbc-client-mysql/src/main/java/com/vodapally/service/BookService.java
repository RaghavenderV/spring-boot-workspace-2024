package com.vodapally.service;

import com.vodapally.entity.Book;
import com.vodapally.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public int addNewBook(Book book){
        return bookRepository.addNewBook(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public Optional<Book> getBookById(int id){
        return bookRepository.getBookById(id);
    }

    public int updateBook(Book book){
        return bookRepository.updateBook(book);
    }

    public int deleteById(int id){
        return bookRepository.deleteById(id);
    }
}
