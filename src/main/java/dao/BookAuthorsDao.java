package main.java.dao;

import main.java.table.BookAuthors;

import java.sql.SQLException;
import java.util.List;

public interface BookAuthorsDao {
    public void addBookAuthors(BookAuthors bookAuthors) throws SQLException;
    public List<BookAuthors> getBookAuthors() throws SQLException;

}
