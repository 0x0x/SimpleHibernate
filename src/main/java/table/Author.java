package main.java.table;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lekarto
 * Date: 26.11.13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="author")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="last_name")
    private String last_name;

    @Column(name="first_name")
    private String first_name;

    @Column(name="middle_name")
    private String middle_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        if (last_name == null) {
            this.last_name = "";
        } else {
            this.last_name = last_name;
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if (first_name == null) {
            this.first_name = "";
        } else {
            this.first_name = first_name;
        }
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        if (middle_name == null) {
            this.middle_name = "";
        } else {
            this.middle_name = middle_name;
        }
    }
}
