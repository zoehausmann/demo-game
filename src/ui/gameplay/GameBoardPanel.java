package ui.gameplay;

import gameplay.GLOBALS;
import gameplay.GameBoardModel;
import manager.GameplayManager;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Creates a visual representation of grid of TurnTableModel
 * in the form of a JPanel table.
 *
 * Created using the following resources:
 *
 * Code Java - How to make Editable JTable in Java Swing
 * https://www.codejava.net/java-se/swing/editable-jtable-example
 *
 * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#renderer
 *
 * @author Zoë Hausmann
 */
public class GameBoardPanel extends JPanel {
    private static final int ROW_HEIGHT = 30;
    private final GameBoardModel model;

    public GameBoardPanel() {
        // Get the model
        model = GameplayManager.getInstance().getModel();

        TableCellRenderer colorRenderer = new ColorRenderer();

        // Create the table
        JTable table = new JTable(model) {
            public TableCellRenderer getCellRenderer(int row, int column) {
                if ((column == 0)) {
                    return colorRenderer;
                }
                return super.getCellRenderer(row, column);
            }
        };
        table.getTableHeader().setReorderingAllowed(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(30);

        // Center all text
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(GLOBALS.FG_COLOR);
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(String.class, cellRenderer);

        // Add the table to the frame
        final JScrollPane scrollPane = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Dimension d = table.getPreferredSize();
        table.getTableHeader().setPreferredSize(
                new Dimension(scrollPane.getWidth() * 2, ROW_HEIGHT)
        );
        // Extra 30 to make it full width
        scrollPane.setPreferredSize(new Dimension(d.width * 2, table.getRowHeight() * (GLOBALS.TURNS + 1)));
        this.add(scrollPane);
    }

    /**
     * Custom table cell renderer for first column of table
     */
    public static class ColorRenderer extends JLabel implements TableCellRenderer {
        public ColorRenderer() {
            setOpaque(true); // MUST do this for background to show up.
        }

        public Component getTableCellRendererComponent(
                JTable table, Object color,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            setBackground(GLOBALS.BG_COLOR);
            setForeground(Color.WHITE);
            setText("ROUND " + (row + 1));
            setHorizontalAlignment(JLabel.CENTER);
            return this;
        }
    }
}