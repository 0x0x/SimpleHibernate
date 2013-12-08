package main.java.dao.implementation;

import main.java.dao.AuthorDao;
import main.java.table.Author;
import main.java.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    @Override
    public void addAuthor(Author author) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(author);
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
    public void deleteAuthor(Author author) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(author);
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
    public Author getAuthor(int id) throws SQLException {
        Author result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Author) session.get(Author.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

        return result;
    }

    @Override
    public List<Author> getAuthors() throws SQLException {
        List<Author> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result =  session.createCriteria(Author.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }
}