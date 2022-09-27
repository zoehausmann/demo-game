package ui;

import manager.GameManager;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerDataPanel extends JPanel {
    private static final String actionList[] = {"Punch", "Kick", "Special", "Duck", "Jump", "Block"};

    public PlayerDataPanel() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 1.0;

        JLabel label;
        JComboBox options;
        JButton button;

        // ROW 3
        label = new JLabel("   ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        this.add(label, c);

        for (int i = 1; i <= GameManager.ACTIONS; i++) {
            label = new JLabel("Move " + i);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 1;
            c.gridx = i;
            c.gridy = 2;
            this.add(label, c);
        }

        label = new JLabel("   ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = GameManager.ACTIONS + 1;
        c.gridy = 2;
        this.add(label, c);

        // ROW 3
        label = new JLabel("   ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        this.add(label, c);

        for (int i = 1; i <= GameManager.ACTIONS; i++) {
            options = new JComboBox(actionList);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 1;
            c.gridx = i;
            c.gridy = 2;
            this.add(options, c);
        }

        label = new JLabel("   ");
        button = new JButton("Confirm");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = GameManager.ACTIONS + 1;
        c.gridy = 2;
        this.add(button, c);
    }
}
