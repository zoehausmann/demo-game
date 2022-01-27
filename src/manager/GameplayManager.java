package manager;

import character.GameCharacter;
import gameplay.Board;

/**
 * GameplayManager functions as a Controller for one round of the game.
 * GameManager creates and maintains a singular instance of GameplayManager.
 * After the round is completed, returns to GameManager for next steps.
 * @author Zoë Hausmann
 */
public class GameplayManager {
    // CONSTANTS
    /** Attacking player */
    private GameCharacter attacker;
    /** Defending player */
    private GameCharacter defender;
    /** Number of turns */
    private int turns;
    /** Number of moves per turn */
    private int moves;

    // VARIABLES

    // GAMEPLAY MANAGER SINGLETON PATTERN
    /** Single instance of GameplayManager **/
    private static GameplayManager instance;
    /** Private constructor for one-time GameplayManager creation. */
    private GameplayManager() { /** Nothing to do */ }
    /** Creates instance at class loading time. */
    static { instance = new GameplayManager(); }
    /** Static instance method */
    protected static GameplayManager getInstance() { return instance; }

    /**
     * Reset the state of the GameplayManager.
     */
    protected static void reset() {
        instance = null;
        instance = new GameplayManager();
    }

    /**
     * Starts a new round of the game with new character choices.
     * @param attacker attacking character
     * @param defender defending character
     */
    protected void newGame(GameCharacter attacker, GameCharacter defender,
                           int turns, int moves) {
        reset();
        this.attacker = attacker;
        this.defender = defender;
        this.turns = turns;
        this.moves = moves;
        play();
    }


    // GETTERS AND SETTERS
    /**
     * Assigns the given character as the attacker.
     * @param character character selected to be the attacker
     */
    public void setAttacker(GameCharacter character) {
        this.attacker = character;
    }

    /**
     * Assigns the given character as the defender.
     * @param character character selected to be the defender
     */
    public void setDefender(GameCharacter character) { this.defender = character; }

    public gameplay.Move[] getAttackPattern() {
        return att
    }

    // GAMEPLAY
    /**
     * Starts the round and manages all subsequent gameplay.
     *
     */
    public void play() {
        Board board = new Board(turns, moves);
        // TODO: set up UI - GameplayUIManager(attacker, defender, turns, moves);


    }

    private void takeTurn() {

    }
    /**
     * Returns the number of partially successful moves.
     * @return the number of partially successful moves
    private int takeHit(Move def, Move att) {

    }

    public void setAttackPattern(Move m1, Move m2, Move m3, Move m4, Move m5) {
        Move[] attackPattern = {m1, m2, m3, m4, m5};
    }

 */
}