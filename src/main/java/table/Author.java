package main.java.table;

import javax.persistence.*;

@Entity
@Table(name="author")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public String getMiddle_name() {
        return middleName;
    }

    public void setMiddle_name(String middleName) {
        if (middleName == null) {
            this.middleName = "";
        } else {
            this.middleName = middleName;
        }
    }
}
