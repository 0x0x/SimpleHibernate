package main.java.general;

import main.java.dao.AuthorDao;
import main.java.dao.BookDao;
import main.java.dao.implementation.AuthorDaoImpl;
import main.java.dao.implementation.BookDaoImpl;

public class Factory {
    public static Factory instance = new Factory();
    public BookDao bookDao;
    public AuthorDao authorDao;

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
}