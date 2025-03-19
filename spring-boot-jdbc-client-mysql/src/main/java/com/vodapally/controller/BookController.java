package com.vodapally.controller;

import com.vodapally.entity.Book;
import com.vodapally.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String addNewBook(@RequestBody Book book) {
        System.out.println("Book---------->" + book);
        int id = bookService.addNewBook(book);

        return id==1?"Added new book successfully!!":"Error creating book";
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookById(@PathVariable(name = "bookId") int id) {
        return bookService.getBookById(id);
    }

    @PutMapping
    public String updateBook(@RequestBody Book book) {
        int id = bookService.updateBook(book);
        return id==1?"Updated book successfully!!":"Error updating book";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        int i = bookService.deleteById(id);
        return i==1?"Book deleted successfully!!":"Error deleting book";
    }
}
