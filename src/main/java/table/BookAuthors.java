package main.java.table;

import javax.persistence.*;

@Entity
@Table(name="book_authors")
public class BookAuthors {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public Author getAuthor() {
        return  author;
    }
}
