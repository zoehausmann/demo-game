package ui;

import manager.GameManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * UI JPanel component representing the player's information and controls
 *
 * Created using the following resources:
 * Oracle - How to Use GridBagLayout
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *
 * @author Zoë Hausmann
 */
public class PlayerDataPanel extends JPanel {
    /** List of action choices for each player move */
    private static final String[] actionList = {"Punch", "Kick", "Special", "Duck", "Jump", "Block"};
    private ArrayList<JComboBox> boxes;
    /**
     * Constructs PlayerDataPanel
     */
    public PlayerDataPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 1.0;

        JLabel label;
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0,GameManager.ACTIONS + 2));

        // Row 1: Move Labels
        grid.add(new JLabel(" "));
        for (int i = 1; i <= GameManager.ACTIONS; i++)
            grid.add(new JLabel("Move " + i, SwingConstants.CENTER));
        grid.add(new JLabel(" "));

        // Row 2: JComboBoxes
        grid.add(new JLabel(" "));
        for (int i = 1; i <= GameManager.ACTIONS; i++) {
            JComboBox box = new JComboBox<>(actionList);
            grid.add(box);
        }
        //grid.add(confirmButton);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(grid, c);

        // Row 3: Player Image
        label = new JLabel("", SwingConstants.RIGHT);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("test-files/test-image.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        label.setIcon(imageIcon);
        label.setBorder(new EmptyBorder(20, 0, 18, 0));
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.add(label, c);

        // Row 4: Player Name
        label = new JLabel("Character Name", SwingConstants.RIGHT);
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        this.add(label, c);
    }

   public ArrayList<String> getBoxData() {
        ArrayList<String> selections = new ArrayList<>();
        for (int i = 0; i < GameManager.ACTIONS; i++) {
            String temp = boxes.get(i).getSelectedItem().toString();
            selections.add(temp);
        }
        return selections;
    }
}
