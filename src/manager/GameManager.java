package manager;

import character.GameCharacter;
import io.ReadCharactersIO;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Manages the game for the duration of the program.
 * @author Zoë Hausmann
 */
public class GameManager {
    // CONSTANTS
    /** Number of actions per turn */
    public static final int ACTIONS = 5;
    /** Number of turns per game */
    public static final int TURNS = 10;
    /** Default game character data */
    private final String DEFAULT_CHARS= "game-files/default-characters";
    /** User-created character data */
    private final String USER_CHARS= "game-files/user-characters";

    // VARIABLES
    /** List of default characters */
    ArrayList<GameCharacter> defaultCharList;
    /** List of user-created characters */
    ArrayList<GameCharacter> userCharList;

    ArrayList<GameCharacter> NPC;
    ArrayList<GameCharacter> Player;

    // GAME MANAGER SINGLETON PATTERN
    /** Single instance of GameManager **/
    private static GameManager instance;
    /** Private constructor for one-time GameManager creation. */
    private GameManager() { /** Nothing to do */ }
    /** Creates instance at class loading time. */
    static { instance = new GameManager(); }
    /** Static instance method */
    public static GameManager getInstance() { return instance; }

    // PRINT
    /** Prints a horizontal border line for game menus. */
    public static void printBorder() { System.out.println("///////////////////////////////////"); }

    /** Prints a blank line with side borders for game menus. */
    public static void printBlank() { System.out.println("//                               //"); }

    /** Prints out main menu. */
    public static void printMenu() {
        printBorder();
        printBlank();
        System.out.println("//    WELCOME TO FEMME FATALE    //");
        System.out.println("//    N - New Game               //");
        System.out.println("//    H - How to Play            //");
        System.out.println("//    G - Character Gallery      //");
        System.out.println("//    C - Custom Characters      //");
        System.out.println("//    E - Exit Game              //");
        printBlank();
        printBorder();
    }

    /** Prints out invalid selection message. */
    public static void printInvalid() {
        printBlank();
        System.out.println("//       INVALID SELECTION       //");
        printBlank();
    }

    // MAIN MENU

    /**
     * Prints the main menu and prompts user to make a choice.
     * Loops until user chooses to exit.
     */
    public static void main(String[] args) {
        String choice;                          // Menu selection
        Scanner in = new Scanner(System.in);    // Read user's selection

        do {                                    // Until user chooses to exit:
            printMenu();                        // Print main menu
            choice = in.next();                 // Wait for user input
            choice.toUpperCase();               // Convert to upper case
/**
            switch (choice) {
                case "N" -> newGame();           // If user chose N, start new game
                case "H": // howToPlay();        // Go to "How to Play" menu
                    break;
                case "G":                       // Display character gallery
                    break;
                case "C":           // If user chooses "C"
                    // customCharacters();         // Go to character editor
                    break;
                case "E" -> quitGame();       // Exit program
                    break;
                default -> printInvalid();        // Else, print invalid message
            }
 */
        } while ( !choice.equals("E") );        // Until user chooses to exit:
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
