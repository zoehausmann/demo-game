/**
 * Created using the following resources:
 * Alex Lee - "Java GUI Tutorial - Make a GUI in 13 Minutes"
 * Alex Lee - "Java GUI Tutorial - Make a Login GUI"
 *
 * Java Tutorials Code Sample – GridLayoutDemo.java with the following disclaimer:
 *  Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 *  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  package ui;
 */

package ui;

import manager.GameManager;
import model.Turn;
import model.TurnTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener {

    /** All possible actions the player can guess for the NPC's move */
    /** Button to confirm player's selection of moves */
    protected JButton confirmButton;
    /** List of action choices for each player move */
    private static final String[] actionList = {"Punch", "Kick", "Special", "Duck", "Jump", "Block"};
    private ArrayList<JComboBox> boxes = new ArrayList<>();

    /** Grid of moves*/
    private JPanel moveGrid;
    private JPanel npcData;
    private JPanel turnTable;
    private JPanel playerData;
    private int turnCount = 0;

    public GUI(String name) {
        super(name);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        // CREATE NPC PANEL
        npcData = new NPCDataPanel();
        npcData.setBorder(new EmptyBorder(20, 20, 10, 20));

        // CREATE TURN PANEL
        turnTable = new TurnTablePanel();
        turnTable.setBorder(new EmptyBorder(10, 20, 10, 20));

        // CREATE PLAYER PANEL
        playerData = new JPanel();
        playerData.setLayout(new GridBagLayout());
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
            boxes.add(box);
            grid.add(box);
        }
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new GUI(this.getName()));
        grid.add(confirmButton);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        playerData.add(grid, c);

        // Row 3: Player Image
        label = new JLabel("", SwingConstants.RIGHT);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("test-files/test-image.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        label.setIcon(imageIcon);
        label.setBorder(new EmptyBorder(20, 0, 18, 0));
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        playerData.add(label, c);

        // Row 4: Player Name
        label = new JLabel("Character Name", SwingConstants.RIGHT);
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        playerData.add(label, c);
        playerData.setBorder(new EmptyBorder(10, 20, 20, 20));

        pane.add(npcData, BorderLayout.NORTH);
        pane.add(turnTable, BorderLayout.CENTER);
        pane.add(playerData, BorderLayout.SOUTH);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        GUI frame = new GUI("Demo Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i <= GameManager.ACTIONS; i++) {
            String temp = this.boxes.get(i - 1).getSelectedItem().toString();
            ((TurnTablePanel) turnTable).setValueAt(turnCount, i, temp);
        }
        turnCount++;

    }
}
