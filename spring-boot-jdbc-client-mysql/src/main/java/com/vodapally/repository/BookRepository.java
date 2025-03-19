package com.vodapally.repository;

import com.vodapally.entity.Book;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private final JdbcClient jdbcClient;

    public BookRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public int addNewBook(Book book){
        return jdbcClient.sql("INSERT INTO Book (id, name, title) values (:id, :name, :title)")
                .param("id", book.getId())
                .param("name", book.getName())
                .param("title", book.getTitle())
                .update();
    }

    public List<Book> getAllBooks(){
        return jdbcClient.sql("SELECT * FROM BOOK")
                .query(Book.class)
                .list();
    }

    public Optional<Book> getBookById(int id){
        return jdbcClient.sql("SELECT * FROM BOOK where id=:id")
                .param("id",id)
                .query(Book.class)
                .optional();
    }

    public int updateBook(Book book){
        return jdbcClient.sql("UPDATE Book SET name=:name , title=:title where id=:id")
                .param("name", book.getName())
                .param("title", book.getTitle())
                .param("id", book.getId())
                .update();
    }

    public int deleteById(int id){
        return jdbcClient.sql("DELETE FROM Book WHERE id=:id")
                .param("id",id)
                .update();
    }
}
