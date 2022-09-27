package ui;

import manager.GameManager;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NPCDataPanel extends JPanel {
    public NPCDataPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 1.0;

        JLabel label;

        // ROW 1
        label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("test-files/test-image.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        label.setIcon(imageIcon);
        c.ipady = 10;
        c.gridwidth = 7;
        c.gridx = 0;
        c.gridy = 0;
        this.add(label, c);

        // ROW 2
        label = new JLabel("Character Name");
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = 7;
        c.gridx = 0;
        c.gridy = 1;
        this.add(label, c);

        // ROW 3
        label = new JLabel("P1:", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        this.add(label, c);

        for (int i = 1; i <= GameManager.ACTIONS; i++) {
            label = new JLabel(" ? ", SwingConstants.CENTER);
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
    }
}
