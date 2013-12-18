package main.java.general;

import main.java.dao.AuthorDao;
import main.java.dao.BookDao;
import main.java.forms.FormTable;
import main.java.table.Author;
import main.java.table.Book;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Hibernate {
    public static void  main(String[] args) throws SQLException {
        Factory factory = Factory.getInstance();
        BookDao bookDao = factory.getBookDao();
        AuthorDao authorDao = factory.getAuthorDao();

    // uncomment this block for adding new books in table "books"
        /*Book book = new Book();

        book.setTitle("Java for Dummiers");
        book.setDescription("description language java");
        book.setIsbn(12345789);

        bookDao.addBook(book);
        */

    // uncomment this block for adding new author in table "author"
        /*Author author_new = new Author();
        author_new.setFirst_name("Gerberd");
        author_new.setLast_name("Shildt");

        authorDao.addAuthor(author_new);*/

    // uncomment this block for printing in console all books from table "book"
        List<Book> books = bookDao.getBooks();

        System.out.println("id  |  isbn  |  title  |  description");

        for (Book book : books) {
            System.out.println(book.getId() + " | " + book.getIsbn() + " | " +
                               book.getTitle() + " | " + book.getDescription());
        }
        /*
        List<Author> authors = authorDao.getAuthors();
        System.out.println("id | first_name | middle_name | last_name");

        for (Author author : authors) {
            System.out.println(author.getId() + " | " + author.getFirst_name() + " | " +
                               author.getMiddle_name() + " | " + author.getLast_name());
        }
        */

        // Forms block;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame bookFrame = new FormTable("Book");
                bookFrame.pack();
                bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                bookFrame.setVisible(true);
            }
        });
    }
}
