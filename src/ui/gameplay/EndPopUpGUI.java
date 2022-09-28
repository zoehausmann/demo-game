package ui.gameplay;

import gameplay.GLOBALS;
import manager.GameManager;
import manager.GameplayManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * UI JPanel component representing the player's information and controls
 *
 * Created using the following resources:
 * Oracle - How to Use GridBagLayout
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *
 * https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
 *
 * @author Zoë Hausmann
 */
public class EndPopUpGUI extends JFrame implements ActionListener {

    private enum Buttons {
        NEW_GAME,
        EXIT
    }

    /**
     * Constructs PlayerDataPanel
     */
    public EndPopUpGUI() {
        super(GLOBALS.GAME_NAME);
        setResizable(false);
    }

    public void addComponentsToPane(final Container pane) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.weightx = 1.0;
        c.weighty = 1.0;

        // Row 1: Message
        JLabel label = new JLabel();
        if(GameplayManager.getInstance().checkWinCond())
            label.setText("Congratulations! You won! Play again?");
        else
            label.setText("Better luck next time! Play again?");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        // Row 2: Buttons
        JButton button1 = new JButton("New Game");
        button1.addActionListener(new EndPopUpGUI());
        button1.setActionCommand(Buttons.NEW_GAME.name());
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(button1, c);

        JButton button2 = new JButton("Exit");
        button2.addActionListener(new EndPopUpGUI());
        button2.setActionCommand(Buttons.EXIT.name());
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(button2, c);

        pane.add(panel, BorderLayout.CENTER);
    }

    public void setupEndPopUpGUI() {
        //Create and set up the window.
        EndPopUpGUI frame = new EndPopUpGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Buttons.NEW_GAME.name())) {
            GameManager.newGame();
            this.dispose();
        } else if (e.getActionCommand().equals(Buttons.EXIT.name())) {
            System.exit(0);
        }
    }
}