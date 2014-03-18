package main.java.dao.implementation;

import main.java.dao.BookAuthorsDao;
import main.java.table.BookAuthors;
import main.java.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BookAuthorsDaoImpl implements BookAuthorsDao {

    @Override
    public void addBookAuthors(BookAuthors bookAuthors) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(bookAuthors);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public List<BookAuthors> getBookAuthors() throws SQLException {
        List<BookAuthors> bookAuthors = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            bookAuthors = session.createCriteria(BookAuthors.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return bookAuthors;
    }
}
