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

package ui.gameplay;

import gameplay.GLOBALS;
import manager.GameplayManager;
import gameplay.Action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameplayGUI extends JFrame implements ActionListener {

    /** Button to confirm player's selection of moves */
    protected JButton confirmButton;
    /***/
    GameplayGUI frame;
    private JLabel npcMove1;
    private JLabel npcMove2;
    private JLabel npcMove3;
    private JLabel npcMove4;
    private JLabel npcMove5;
    private JComboBox playerMove1;
    private JComboBox playerMove2;
    private JComboBox playerMove3;
    private JComboBox playerMove4;
    private JComboBox playerMove5;

    public GameplayGUI() {
        super(GLOBALS.GAME_NAME);
        setResizable(false);
    }
    public void addComponentsToPane(final Container pane) {
        // CREATE NPC PANEL
        JPanel npcData = new JPanel();
        npcData.setBorder(new EmptyBorder(20, 20, 10, 20));
        npcData.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 1.0;

        JLabel label;

        // ROW 1
        label = new JLabel();
        ImageIcon npcImageIcon = new ImageIcon(new ImageIcon(GLOBALS.getNPC().getPfp()).getImage()
                .getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        label.setIcon(npcImageIcon);
        c.ipady = 10;
        c.gridwidth = GLOBALS.ACTIONS + 2;
        c.gridx = 0;
        c.gridy = 0;
        npcData.add(label, c);

        // ROW 2
        label = new JLabel(GLOBALS.getNPC().getName());
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;      //make this component tall
        c.gridwidth = GLOBALS.ACTIONS + 2;
        c.gridx = 0;
        c.gridy = 1;
        npcData.add(label, c);

        // ROW 3
        label = new JLabel("P1:", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        npcData.add(label, c);

        ////////////////////////////////////////
        /// DISALLOWS CUSTOM NUMBER OF TURNS ///
        ////////////////////////////////////////
        npcMove1 = new JLabel(" ? ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        npcData.add(npcMove1, c);

        npcMove2 = new JLabel(" ? ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        npcData.add(npcMove2, c);

        npcMove3 = new JLabel(" ? ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        npcData.add(npcMove3, c);

        npcMove4 = new JLabel(" ? ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 2;
        npcData.add(npcMove4, c);

        npcMove5 = new JLabel(" ? ", SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 5;
        c.gridy = 2;
        npcData.add(npcMove5, c);

        label = new JLabel("   ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = GLOBALS.ACTIONS + 1;
        c.gridy = 2;
        npcData.add(label, c);

        // CREATE TURN PANEL
        JPanel turnTable = new GameBoardPanel();
        turnTable.setBorder(new EmptyBorder(10, 20, 10, 20));

        // CREATE PLAYER PANEL
        JPanel playerData = new JPanel();
        playerData.setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();
        d.fill = GridBagConstraints.HORIZONTAL;
        d.weightx = 1.0;
        d.weighty = 1.0;

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0, GLOBALS.ACTIONS + 2));

        // Row 1: Move Labels
        grid.add(new JLabel(" "));
        for (int i = 1; i <= GLOBALS.ACTIONS; i++)
            grid.add(new JLabel("Move " + i, SwingConstants.CENTER));
        grid.add(new JLabel(" "));

        ////////////////////////////////////////
        /// DISALLOWS CUSTOM NUMBER OF TURNS ///
        ////////////////////////////////////////
        // Row 2: JComboBoxes
        grid.add(new JLabel(" "));

        playerMove1 = new JComboBox<>();
        playerMove1.setModel(new DefaultComboBoxModel<>(gameplay.Action.values()));
        playerMove1.setSelectedItem(Action.PUNCH);
        playerMove2 = new JComboBox<>();
        playerMove2.setModel(new DefaultComboBoxModel<>(gameplay.Action.values()));
        playerMove2.setSelectedItem(Action.PUNCH);
        playerMove3 = new JComboBox<>();
        playerMove3.setModel(new DefaultComboBoxModel<>(gameplay.Action.values()));
        playerMove3.setSelectedItem(Action.PUNCH);
        playerMove4 = new JComboBox<>();
        playerMove4.setModel(new DefaultComboBoxModel<>(gameplay.Action.values()));
        playerMove4.setSelectedItem(Action.PUNCH);
        playerMove5 = new JComboBox<>();
        playerMove5.setModel(new DefaultComboBoxModel<>(gameplay.Action.values()));
        playerMove5.setSelectedItem(Action.PUNCH);
        grid.add(playerMove1);
        grid.add(playerMove2);
        grid.add(playerMove3);
        grid.add(playerMove4);
        grid.add(playerMove5);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(GameplayManager.getInstance());
        confirmButton.addActionListener(this);
        grid.add(confirmButton);

        d.gridwidth = 1;
        d.gridx = 0;
        d.gridy = 0;
        playerData.add(grid, d);

        // Row 3: Player Image
        label = new JLabel("", SwingConstants.RIGHT);
        ImageIcon playerImageIcon = new ImageIcon(new ImageIcon(GLOBALS.getPlayer().getPfp()).getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        label.setIcon(playerImageIcon);
        label.setBorder(new EmptyBorder(20, 0, 18, 0));
        d.gridwidth = 1;
        d.gridx = 0;
        d.gridy = 1;
        playerData.add(label, d);

        // Row 4: Player Name
        label = new JLabel(GLOBALS.getPlayer().getName(), SwingConstants.RIGHT);
        label.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        d.gridwidth = 1;
        d.gridx = 0;
        d.gridy = 2;
        playerData.add(label, d);
        playerData.setBorder(new EmptyBorder(10, 20, 20, 20));

        pane.add(npcData, BorderLayout.NORTH);
        pane.add(turnTable, BorderLayout.CENTER);
        pane.add(playerData, BorderLayout.SOUTH);
    }

    ////////////////////////////////////////
    /// DISALLOWS CUSTOM NUMBER OF TURNS ///
    ////////////////////////////////////////
    public ArrayList<Action> getActions() {
        ArrayList<Action> playerActions = new ArrayList<>();
        playerActions.add((Action) frame.playerMove1.getSelectedItem());
        playerActions.add((Action) frame.playerMove2.getSelectedItem());
        playerActions.add((Action) frame.playerMove3.getSelectedItem());
        playerActions.add((Action) frame.playerMove4.getSelectedItem());
        playerActions.add((Action) frame.playerMove5.getSelectedItem());
        return playerActions;

    }

    public void setupGameplayGUI() {
        //Create and set up the window.
        frame = new GameplayGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void updateGameplayGUI() {
        frame.getContentPane().repaint();
    }

    public void exitGame() {
        frame.dispose();
    }

    private void endGame() {
        confirmButton.setEnabled(false);
        ArrayList<Action> actions = GameplayManager.getInstance().npcActions();
        npcMove1.setText(actions.get(0).toString());
        npcMove2.setText(actions.get(1).toString());
        npcMove3.setText(actions.get(2).toString());
        npcMove4.setText(actions.get(3).toString());
        npcMove5.setText(actions.get(4).toString());
    }
    /**
     * After all turns are completed, reveals the NPC's moves and disables
     * the confirm button.
     *
     * @param e button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // After all turns completed, end the game
        if(GameplayManager.getInstance().checkWinCond() ||
        (GLOBALS.getTurnCount() >= GLOBALS.TURNS - 1)) {
            endGame();
            EndPopUpGUI gui = new EndPopUpGUI();
            gui.setupEndPopUpGUI();
        }
    }
}
