package main.java.dao;

import main.java.table.Author;
import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
    public void addAuthor(Author author) throws SQLException;
    public void deleteAuthor(Author author) throws SQLException;
    public Author getAuthor(int id) throws SQLException;
    public List<Author> getAuthors() throws SQLException;
}
