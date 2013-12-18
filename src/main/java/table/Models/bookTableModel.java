package main.java.table.Models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lekarto
 * Date: 18.12.13
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class bookTableModel extends AbstractTableModel {
    private int colCount = 4;
    private ArrayList<String []> dataArrayList;

    public bookTableModel() {
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dataArrayList.get(rowIndex)[columnIndex];
    }

    public String[] getRowValueAt(int rowIndex) {
        return dataArrayList.get(rowIndex).clone();
    }

    public String getColumnName(int colIndex) {
        switch (colIndex) {
            case 0: return "#id";
            case 1: return "title";
            case 2: return "ISBN";
            case 3: return "Description";
        }
        return "";
    }

    public void addData(String []row) {
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable.clone());
    }

    public void deleteData(int delIndex) {
        dataArrayList.remove(delIndex);
        fireTableStructureChanged(); // for visual update table
    }

    public void clearData() {
        dataArrayList.clear();
        fireTableStructureChanged(); // for visual update table
    }
}
