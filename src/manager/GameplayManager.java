package manager;

import gameplay.Action;
import gameplay.GameBoardModel;
import gameplay.GLOBALS;
import gameplay.Turn;
import ui.gameplay.Buttons;
import ui.gameplay.GameplayGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * GameplayManager functions as a Controller for an instance of the game.
 * A singular instance of GameplayManager is maintained by GameManager.
 *
 * When triggered by an ActionListener in the GameplayGUI, GameManager executes the appropriate action.
 *
 * After the round is completed, returns to GameManager for next steps.
 *
 *
 *
 * @author Zoë Hausmann
 */
public class GameplayManager implements ActionListener  {
    // VARIABLES
    /** List of NPC actions*/
    private ArrayList<Action> npcActions;
    /** Live model of the game board */
    private GameBoardModel model;
    static GameplayGUI gui;


    // GAME MANAGER SINGLETON PATTERN
    public static volatile GameplayManager instance = null;
    /** Private constructor for one-time GameManager creation. */
    private GameplayManager() { /** Nothing to do */ }
    /** Creates instance at class loading time. */
    static { instance = new GameplayManager(); }
    /** Static instance method */
    public static GameplayManager getInstance() { return instance; }

    // GETTERS AND SETTERS
    public GameBoardModel getModel() {
        return model;
    }

    public static void reset() {
        instance = new GameplayManager();
    }

    // GAMEPLAY
    public void setup() {
        // Generates NPC actions and adds them to npcActions list
        npcActions = npcActions();

        // Reset turn count
        GLOBALS.resetTurnCount();

        // Create and build game board model
        List<Turn> turnList = new ArrayList<>();
        for (int i = 1; i <= GLOBALS.TURNS; i++)
            turnList.add(new Turn(i));
        model = new GameBoardModel(turnList);

        // Create GUI
        if(gui != null)
            gui.exitGame();
        gui = new GameplayGUI();
        gui.setupGameplayGUI();
    }

    /**
     * Not encapsulated
     */
    public ArrayList<Action> npcActions() {
        npcActions = new ArrayList<>();
        Action temp;
        for (int i = 0; i < GLOBALS.ACTIONS; i++) {
            int rand = (int) Math.floor(Math.random() * 6);
            switch (rand) {
                case 0:
                    temp = Action.PUNCH;
                    break;
                case 1:
                    temp = Action.KICK;
                    break;
                case 2:
                    temp = Action.SPECIAL;
                    break;
                case 3:
                    temp = Action.DUCK;
                    break;
                case 4:
                    temp = Action.JUMP;
                    break;
                default:
                    temp = Action.BLOCK;
            }
            npcActions.add(temp);
        }
        return npcActions;
    }

    public boolean checkWinCond() {
        ArrayList<Action> playerActions = gui.getActions();
        int n = 0;
        for (int i = 0; i < GLOBALS.ACTIONS; i++)
            if (playerActions.get(i) != npcActions.get(i))
                return false;
        return true;
    }

    private void setTableValues() {
        // Add user's selected actions to table
        ArrayList<Action> playerActions = gui.getActions();
        for (int i = 0; i < playerActions.size(); i++) {
            model.setValueAt(GLOBALS.getTurnCount(), i + 1, playerActions.get(i).toString());
        }

        // Create results string of correct an incorrect answers
        String result = "<html>";
        for (int i = 0; i < GLOBALS.ACTIONS; i++) {
            System.out.println(i);
            System.out.println(npcActions.get(i));
            System.out.println(playerActions.get(i));
            System.out.println(gui.getActions().get(i));
            if (npcActions.get(i).compareTo(gui.getActions().get(i)) == 0) {
                result += "<font color=green>● ";
            } else {
                result += "</font><font color=black>○ ";
            }
        }
        result += "</font></html>";

        // If player runs out of turns, results string is all red circles
        if(GLOBALS.getTurnCount() == (GLOBALS.TURNS - 1) && !checkWinCond())
            result = "<html><font color=red>● ● ● ● ● </font></html>>";

        //Add result string to table
        model.setValueAt(GLOBALS.getTurnCount(), GLOBALS.ACTIONS + 1, result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GLOBALS.getTurnCount() < GLOBALS.TURNS) {
            setTableValues();
            gui.updateGameplayGUI();
            GLOBALS.incrementTurnCount();
        }
    }
}