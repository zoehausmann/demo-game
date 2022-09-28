package manager;

import character.GameCharacter;
import gameplay.GLOBALS;
import io.ReadCharactersIO;

import java.util.ArrayList;

/**
 * Manages the game for the duration of the program.
 * @author Zoë Hausmann
 */
public class GameManager {
    // VARIABLES
//    /** List of default characters */
//    ArrayList<GameCharacter> defaultCharList;
//    /** List of user-created characters */
//    ArrayList<GameCharacter> userCharList;
    private GLOBALS globals;

    // GAME MANAGER SINGLETON PATTERN
    /** Single instance of GameManager **/
    private static GameManager instance;
    /** Private constructor for one-time GameManager creation. */
    private GameManager() { /** Nothing to do */ }
    /** Creates instance at class loading time. */
    static { instance = new GameManager(); }
    /** Static instance method */
    public static GameManager getInstance() { return instance; }

    /**
     * Runs the Demo Game program.
     * @param args unused default args
     */
    public static void main(String[] args) {
        // Load singular GameManager instance
        GameManager.getInstance();

        // Read in character list
//        ReadCharactersIO io = new ReadCharactersIO();
//        try {
//            ArrayList<GameCharacter> defaultCharList = io.readCharacters("file");
//        } catch( Exception e) { TODO }

        // Set NPC and player characters
        GameCharacter npc = new GameCharacter("Emet-Selch", "Final Fantasy XIV",
                5, 5, 5, 5, 5, 5, "test-files/emet-selch.png");
        GameCharacter player = new GameCharacter("Zoë", "Durham, NC",
                3, 2, 5, 4, 3, 2, "test-files/zoe.png");
        GLOBALS globals = new GLOBALS(npc, player);

        // New game
        newGame();
    }

    public static void newGame() {
        // Load singular GameplayManager instance and begin game setup
        GameplayManager gameplayManager = GameplayManager.getInstance();
        gameplayManager.setup();
    }

    /** Exits program. */
    public static void quitGame() { System.exit(0); }
}
