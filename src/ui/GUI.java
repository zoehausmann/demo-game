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

import model.NPCData;
import model.TurnTable;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

    /** All possible actions the player can guess for the NPC's move */
    private static final String actionList[] = {"Punch", "Kick", "Jump", "Dodge", "Special"};
    /** Options for the first move */
    JComboBox choiceOne;
    /** Options for the second move */
    JComboBox choiceTwo;
    /** Options for the third move */
    JComboBox choiceThree;
    /** Options for the fourth move */
    JComboBox choiceFour;
    /** Options for the fifth move */
    JComboBox choiceFive;
    /** Button to confirm player's selection of moves */
    private JButton confirmButton = new JButton("Confirm");

    /** Grid of moves*/
    private JPanel moveGrid;

    public GUI(String name) {
        super(name);
        setResizable(false);
    }

    public void createActionList(){
        choiceOne = new JComboBox(actionList);
        choiceTwo = new JComboBox(actionList);
        choiceThree = new JComboBox(actionList);
        choiceFour = new JComboBox(actionList);
        choiceFive = new JComboBox(actionList);
    }
    public void addComponentsToPane(final Container pane) {
        // NORTH: Create NPC panel
        JPanel npcData = new NPCData();
        npcData.setBorder(new EmptyBorder(20, 20, 10, 20));

        // CENTER: Create table of turns and add to the frame
        JPanel table = new TurnTable();
        table.setBorder(new EmptyBorder(10, 0, 10, 0));


        // Create player controls panel
        createActionList();
        JPanel controls = new JPanel();
        controls.setBorder(new EmptyBorder(10, 20, 20, 20));
        controls.setLayout(new GridLayout(0,7));


        // SOUTH: Add player controls
        controls.add(new Label(""));
        controls.add(new Label("Move 1", SwingConstants.CENTER));
        controls.add(new Label("Move 2", SwingConstants.CENTER));
        controls.add(new Label("Move 3", SwingConstants.CENTER));
        controls.add(new Label("Move 4", SwingConstants.CENTER));
        controls.add(new Label("Move 5", SwingConstants.CENTER));
        controls.add(new Label(""));
        controls.add(new Label(""));
        controls.add(choiceOne);
        controls.add(choiceTwo);
        controls.add(choiceThree);
        controls.add(choiceFour);
        controls.add(choiceFive);
        controls.add(confirmButton);

        pane.add(npcData, BorderLayout.NORTH);
        pane.add(table, BorderLayout.CENTER);
//        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
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
}
