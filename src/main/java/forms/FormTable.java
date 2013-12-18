package main.java.forms;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import main.java.table.Models.bookTableModel;
import main.java.table.Book;
import main.java.dao.BookDao;
import main.java.general.Factory;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Lekarto
 * Date: 18.12.13
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
public class FormTable extends JFrame {
    private JButton btnAdd, btnDelete, btnCrear;
    private JTable table;
    private JScrollPane tableScrollPane;
    private bookTableModel bookTM;

    private void initTableData() {
        Factory factory = Factory.getInstance();
        BookDao bookDao = factory.getBookDao();
        try {
            List<Book> books = bookDao.getBooks();
            String []str4 = new String[4];
            for (Book book : books) {
                str4[0] = Integer.toString(book.getId());
                str4[1] = Integer.toString(book.getIsbn());
                str4[2] = book.getTitle();
                str4[3] = book.getDescription();
                bookTM.addData(str4.clone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public FormTable(String title) {
        super(title);

        setLayout(new GridBagLayout());

        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnCrear = new JButton("Clear");

        bookTM = new bookTableModel();
        initTableData();

        table = new JTable(bookTM);
        tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(1000, 500));


        getContentPane().add(tableScrollPane, new GridBagConstraints(0, 0, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        getContentPane().add(btnAdd, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        getContentPane().add(btnDelete, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));

        getContentPane().add(btnCrear, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
    }
}
