package ui.gameplay;

/* IMPORTS */
import gameplay.GLOBALS;
import manager.GameManager;
import manager.GameplayManager;
import gameplay.Action;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * User interface for playing the game.
 * Creates visual representation of game board and
 *
 * Created using the following resources:
 * Alex Lee - "Java GUI Tutorial - Make a GUI in 13 Minutes"
 * Alex Lee - "Java GUI Tutorial - Make a Login GUI"
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
public class GameplayGUI extends JFrame implements ActionListener {
    /** Current window */
    private static GameplayGUI frame;
    /** End of game popup window */
    private static EndOfGamePopupGUI eogPopupGUI;

    /** First NPC action */
    private JLabel npcMove1;
    /** Second NPC action */
    private JLabel npcMove2;
    /** Third NPC action */
    private JLabel npcMove3;
    /** Fourth NPC action */
    private JLabel npcMove4;
    /** Fifth NPC action */
    private JLabel npcMove5;

    /** First list of player actions */
    private JComboBox<gameplay.Action> playerMove1;
    /** Second list of player actions */
    private JComboBox<gameplay.Action> playerMove2;
    /** Third list of player actions */
    private JComboBox<gameplay.Action> playerMove3;
    /** Fourth list of player actions */
    private JComboBox<gameplay.Action> playerMove4;
    /** Fifth list of player actions */
    private JComboBox<gameplay.Action> playerMove5;

    /** Button to confirm player action selections */
    protected JButton confirmButton;

    /**
     * Constructs a new Gameplay GUI object with the current
     * program's name and sets resizeable to false.
     */
    public GameplayGUI() {
        super(GLOBALS.GAME_NAME);
        setResizable(false);
    }

    /**
     * Adds content to empty content pane
     * @param pane content pane
     */
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
        confirmButton.setActionCommand(Buttons.CONFIRM.name());
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

    /**
     * Returns list of actions selected and confirmed by the player
     * @return list of actions selected and confirmed by the player
     */
    public ArrayList<Action> getActions() {
        ArrayList<Action> playerActions = new ArrayList<>();
        playerActions.add((Action) frame.playerMove1.getSelectedItem());
        playerActions.add((Action) frame.playerMove2.getSelectedItem());
        playerActions.add((Action) frame.playerMove3.getSelectedItem());
        playerActions.add((Action) frame.playerMove4.getSelectedItem());
        playerActions.add((Action) frame.playerMove5.getSelectedItem());
        return playerActions;

    }

    /**
     * Sets up content pane
     */
    public void setupGameplayGUI() {
        //Create and set up the window.
        frame = new GameplayGUI();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** Repaints current GUI window */
    public void updateGameplayGUI() {
        frame.getContentPane().repaint();
    }

    /** Disposes of current GUI window */
    public void exitGame() {
        frame.dispose();
    }

    /**
     * Disables the confirm button and reveals the NPC's actions chosen
     * at the beginning of the game.
     */
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
     * Enables the popup window for the user to choose whether to exit or
     * start a new game.
     *
     * @param e button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // If all turns completed or player guesses correctly, end the game
        if(GameplayManager.getInstance().checkWinCond() ||
        (GLOBALS.getTurnCount() >= GLOBALS.TURNS - 1)) {
            endGame();
            // Create GUI
            if(eogPopupGUI != null)
                eogPopupGUI.exitPopup();
            eogPopupGUI = new EndOfGamePopupGUI();
            eogPopupGUI.setUpEOGPopupGUI();
        }
        // If the user clicks "New Game", start a new game and hide the popup
        if(e.getActionCommand().equals(Buttons.NEW_GAME.name())) {
            GameManager.newGame();
            eogPopupGUI.exitPopup();
        // If the user clicks "Exit", terminate program with successful exit code
        } else if (e.getActionCommand().equals(Buttons.EXIT.name())) {
            System.exit(0);
        }
    }

    /**
     * Popup window shown at the end of a game to prompt user
     * to either start a new game or exit the program.
     *
     * Created using the following resources:
     * Oracle - How to Use GridBagLayout
     * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

     * @author Zoë Hausmann
     */
    private static class EndOfGamePopupGUI extends JFrame {
        /** Popup window */
        private static EndOfGamePopupGUI popupFrame;

        /**
         * Constructs empty popup with program name and sets resizeable to false
         */
        public EndOfGamePopupGUI() {
            super(GLOBALS.GAME_NAME);
            setResizable(false);
        }

        /**
         * Adds content to empty content pane
         * @param pane content pane
         */
        public void addComponentsToPane(final Container pane) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            panel.setBorder(new EmptyBorder(20, 20, 20, 20));
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(5, 5, 5, 5);
            c.weightx = 1.0;
            c.weighty = 1.0;

            // Row 1: Message
            JLabel label = new JLabel();
            if (GameplayManager.getInstance().checkWinCond())
                label.setText("Congratulations! You won! Play again?");
            else
                label.setText("Better luck next time! Play again?");
            c.gridwidth = 2;
            c.gridx = 0;
            c.gridy = 0;
            panel.add(label, c);

            // Row 2: Buttons
            JButton button1 = new JButton("New Game");
            button1.addActionListener(GameplayGUI.frame);
            button1.setActionCommand(Buttons.NEW_GAME.name());
            c.gridwidth = 1;
            c.gridx = 0;
            c.gridy = 1;
            panel.add(button1, c);

            JButton button2 = new JButton("Exit");
            button2.addActionListener(GameplayGUI.frame);
            button2.setActionCommand(Buttons.EXIT.name());
            c.gridwidth = 1;
            c.gridx = 1;
            c.gridy = 1;
            panel.add(button2, c);

            pane.add(panel, BorderLayout.CENTER);
        }

        /** Disposes of current popup window */
        public void exitPopup() {
            popupFrame.dispose();
        }

        /**
         * Sets up content pane
         */
        public void setUpEOGPopupGUI() {
            //Create and set up the window.
            popupFrame = new EndOfGamePopupGUI();
            popupFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            //Set up the content pane.
            popupFrame.addComponentsToPane(popupFrame.getContentPane());
            //Display the window.
            popupFrame.pack();
            popupFrame.setLocationRelativeTo(null);
            popupFrame.setVisible(true);
        }

    }
}
