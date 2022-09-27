package ui;

import manager.GameManager;
import model.Turn;
import model.TurnTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a visual representation of grid of TurnTableModel
 * in the form of a JPanel table.
 *
 * Created using the following resources:
 *
 * Code Java - How to make Editable JTable in Java Swing
 * https://www.codejava.net/java-se/swing/editable-jtable-example
 *
 * @author Zoë Hausmann
 */
public class TurnTablePanel extends JPanel
{
    private static final int ROW_HEIGHT = 30;
    public TurnTablePanel()
    {
        // Create and build the list
        List<Turn> turnList = new ArrayList<>();
        for (int i = 1; i <= GameManager.TURNS; i++)
            turnList.add(new Turn(i));

        // Create the model
        TurnTableModel model = new TurnTableModel(turnList);

        // Create the table
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(30);

        // Center all text
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, cellRenderer);

        // Add the table to the frame
        final JScrollPane scrollPane = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Dimension d = table.getPreferredSize();
        table.getTableHeader().setPreferredSize(
                new Dimension(scrollPane.getWidth()*2,ROW_HEIGHT)
        );
        // Extra 30 to make it full width
        scrollPane.setPreferredSize(new Dimension(d.width * 2,table.getRowHeight()*(GameManager.TURNS + 1)));
        this.add(scrollPane);
    }

    /**
     * Creates new instance of EditableTurnTable
     * @param args unused default arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new TurnTablePanel());
    }
}