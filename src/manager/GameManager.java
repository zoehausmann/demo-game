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
    // Constants
    /** Default game character data */
    private final String DEFAULT_CHARS= "game-files/default-characters";
    /** User-created character data */
    private final String USER_CHARS= "game-files/user-characters";
    private GLOBALS globals;

    // VARIABLES
//    /** List of default characters */
//    ArrayList<GameCharacter> defaultCharList;
//    /** List of user-created characters */
//    ArrayList<GameCharacter> userCharList;

    GameCharacter NPC;
    GameCharacter Player;

    // GAME MANAGER SINGLETON PATTERN
    /** Single instance of GameManager **/
    private static GameManager instance;
    /** Private constructor for one-time GameManager creation. */
    private GameManager() { /** Nothing to do */ }
    /** Creates instance at class loading time. */
    static { instance = new GameManager(); }
    /** Static instance method */
    public static GameManager getInstance() { return instance; }

    // PUBLIC METHODS
    public void completeTurn() {

    }

    /**
     */
    public static void main(String[] args) {
        GameManager.getInstance();
        GameCharacter npc = new GameCharacter("Emet-Selch", "Final Fantasy XIV",
                5, 5, 5, 5, 5, 5, "test-files/emet-selch.png");
        GameCharacter player = new GameCharacter("Zoë", "Durham, NC",
                3, 2, 5, 4, 3, 2, "test-files/zoe.png");
        GLOBALS globals = new GLOBALS(npc, player);
        // Creates singleton GameplayManager instance
        GameplayManager gameplayManager = GameplayManager.getInstance();
        gameplayManager.setup();
    }

    // NEW GAME
    /**
     * Resets the GameplayManager and starts a new game
     * with given character and gameplay choices.
     */
    private static void newGame() {
        ReadCharactersIO io = new ReadCharactersIO();
        try {
            ArrayList<GameCharacter> defaultCharList = io.readCharacters("file");
        } catch( Exception e) {
          // TODO
        }
        // Character selection
        // Number of turns
        // Number of moves

        // GameplayManager.newGame(turns, moves, attacker, defender);
    }

    // EXIT GAME
    // TODO: prompt user to save current characters
    // exit game

    /** Exits program. */
    public static void quitGame() { System.exit(0); }
}
