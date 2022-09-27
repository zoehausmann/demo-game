package model;

import manager.GameManager;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Model representing the grid of Turns (rows) and Actions (cols)
 * within the game board UI.
 *
 * Created using the following resources:
 *
 * Code Java - How to make Editable JTable in Java Swing
 * https://www.codejava.net/java-se/swing/editable-jtable-example
 *
 * @author Zoë Hausmann
 */
public class TurnTableModel extends AbstractTableModel {
    /** List of Turns (rows) in the game */
    private final List<Turn> turnList;
    /** List of column names */
    private final ArrayList<String> columnNames = new ArrayList<String>();
    /** List of column classes */
    private final ArrayList<Class> columnClass = new ArrayList<Class>();

    /**
     * Model representing the grid of Turns (rows) and Actions (cols)
     * within the game board UI.
     * @param turnList list of Turns (rows) in the game
     */
    public TurnTableModel(List<Turn> turnList) {
        // Set Turn list
        this.turnList = turnList;

        // Add first column name/class
        columnNames.add("RND");
        columnClass.add(String.class);

        // Add action columns names/classes
        for(int i = 1; i <= GameManager.ACTIONS; i++) {
            columnNames.add("A" + i);
            columnClass.add(String.class);
        }

        // Add last column name/class
        columnNames.add("RES");
        columnClass.add(String.class);
    }

    /**
     * Returns the name of the column at the given index
     * @param column index of the column to return
     * @return the name of the column at the given index
     */
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    /**
     * Returns the class of the column at the given index
     * @param columnIndex index of the column
     * @return the class of the column at the given index
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass.get(columnIndex);
    }

    /**
     * Returns the number of columns in the table.
     * @return the number of columns in the table
     */
    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    /**
     * Returns the number of rows in the table.
     * @return the number of rows in the table
     */
    @Override
    public int getRowCount() {
        return turnList.size();
    }

    /**
     * Gets the value at a given row and column in the table.
     * @param rowIndex row of the value
     * @param columnIndex column of the value
     * @return the value at the given row and column
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return turnList.get(rowIndex).getValueAt(columnIndex);
    }

    /**
     * Sets the value at a given row and column in the table.
     * @param rowIndex row of the value
     * @param columnIndex column of the value
     * @param value value to be set
     * @return the value that was set
     */
    public Object setValueAt(int rowIndex, int columnIndex, String value) {
        Turn turn = turnList.get(rowIndex);
        turn.setValueAt(value, columnIndex);
        turnList.set(rowIndex, turn);
        return turnList.get(rowIndex).getValueAt(columnIndex);
    }
}