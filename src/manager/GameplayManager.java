package manager;

import character.GameCharacter;
import gameplay.Action;
import gameplay.GameBoardModel;
import gameplay.GLOBALS;
import gameplay.Turn;
import ui.gameplay.GameplayGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * GameplayManager functions as a Controller for an instance of the game.
 * GameManager creates and maintains a singular instance of GameplayManager.
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
    /** Representation of NPC */
    private GameCharacter npc;
    /** List of NPC actions*/
    private ArrayList<Action> npcActions;
    /** Representation of player character */
    private GameCharacter player;
    /** Live model of the game board */
    private GameBoardModel gameBoardModel;
    /** Live model of the game board */
    private GameBoardModel model;
    static GameplayGUI gui;


    // GAME MANAGER SINGLETON PATTERN
    /** Single instance of GameManager **/
    private static GameplayManager instance;
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

    // GAMEPLAY
    public void setup() {
        // Generates NPC actions and adds them to npcActions list
        // Creates board model
        // Create and build the list
        List<Turn> turnList = new ArrayList<>();
        for (int i = 1; i <= GLOBALS.TURNS; i++)
            turnList.add(new Turn(i));

        // Create the model
        model = new GameBoardModel(turnList);

        gui = new GameplayGUI();
        gui.setupGameplayGUI();

    }

    /**
     * Not encapsulated
     */
    public ArrayList<Action> npcActions() {
        npcActions = new ArrayList<Action>();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GLOBALS.getTurnCount() < GLOBALS.TURNS) {
            ArrayList<Action> playerActions = gui.getActions();
                for (int i = 0; i < playerActions.size(); i++) {
                    model.setValueAt(GLOBALS.getTurnCount(), i + 1, playerActions.get(i).toString());
                }
            gui.updateGameplayGUI();
            GLOBALS.incrementTurnCount();
        }
    }
}