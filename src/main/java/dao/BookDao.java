package main.java.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.table.Book;

public interface BookDao {
    public void addBook(Book book) throws SQLException;
    public void deleteBook(Book book) throws SQLException;
    public Book getBook(int id) throws SQLException;
    public List<Book> getBooks() throws SQLException;
}
