package main.java.general;

import main.java.dao.AuthorDao;
import main.java.dao.BookAuthorsDao;
import main.java.dao.BookDao;
import main.java.dao.implementation.AuthorDaoImpl;
import main.java.dao.implementation.BookAuthorsDaoImpl;
import main.java.dao.implementation.BookDaoImpl;

public class Factory {
    private static Factory instance = new Factory();
    private BookDao bookDao;
    private AuthorDao authorDao;
    private BookAuthorsDao bookAuthorsDao;

    public Factory() { }

    public static Factory getInstance(){
        return Factory.instance;
    }

    public BookDao getBookDao() {
        if (bookDao == null) {
            bookDao = new BookDaoImpl();
        }
        return bookDao;
    }

    public AuthorDao getAuthorDao() {
        if (authorDao == null) {
            authorDao = new AuthorDaoImpl();
        }
        return authorDao;
    }

    public BookAuthorsDao getBookAuthorsDao() {
        if (bookAuthorsDao == null) {
            bookAuthorsDao = new BookAuthorsDaoImpl();
        }
        return bookAuthorsDao;
    }
}