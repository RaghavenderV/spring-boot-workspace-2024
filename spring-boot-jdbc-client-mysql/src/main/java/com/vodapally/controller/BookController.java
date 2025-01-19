package com.vodapally.controller;

import com.vodapally.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private JdbcClient jdbcClient;

    @PostMapping
    public String addNewBook(@RequestBody Book book){
        System.out.println("Book---------->"+book);
        jdbcClient.sql("INSERT INTO Book(id, name, title) values(?,?,?)")
                .param(List.of(book.getId(), book.getName(), book.getTitle()))
                .update();

        return "New Book added successfully";
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return jdbcClient.sql("SELECT id, name, title FROM Book")
                .query(Book.class)
                .list();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookById(@PathVariable int id){
        return jdbcClient.sql("SELECT id, name, title FROM Book where id=:id")
                .param("id",id)
                .query(Book.class)
                .optional();
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book){
        jdbcClient.sql("UPDATE BOOK SET TITLE = ? , NAME=? WHERE ID=?")
                .param(List.of(book.getTitle(), book.getName(), id))
                .update();

        return "Book updated successfully!!";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        jdbcClient.sql("delete from book where id=:id")
                .param("id",id)
                .update();
        return "Book deleted successfully!!";
    }
}
