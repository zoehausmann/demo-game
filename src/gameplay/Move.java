package gameplay;
import character.GameCharacter;
import manager.GameManager;

/**
 * Manages the comparison of the defender's action with the attacker's action.
 * Calculates the amount of damage taken or dealt.
 * @author Zoë Hausmann
 */
public class Move {
    // VARIABLES
    /** Defending character */
    private GameCharacter defender;
    /** Turn number (row) */
    private int turnNumber;
    /** Move number (column) */
    private int moveNumber;

    /**
     * Creates a new instance of Move to track one space on the board
     * @param defender defending character (in order to
     * @param attack
     * @param defense
     */
    public void Move(GameCharacter defender, Action attack, Action defense) {
    }

    public boolean isSuccess(Action attAction, Action defAction) {
        switch(attAction) {
            case PUNCH: if (defAction == Action.DUCK) { return true; };
            case KICK: if (defAction == Action.JUMP) { return true; };
            case SPECIAL: if (defAction == Action.BLOCK) { return true; };
            case DUCK: if (defAction == Action.KICK) { return true; };
            case JUMP: if (defAction == Action.PUNCH ){ return true; };
            case BLOCK: if (defAction == Action.SPECIAL) { return true; };
        }
        return false;
    };
    public int calcDamage() {
        // TODO calculate the damage dealt by the attacker on this move
        return 0;
    }

    public int[] returnColor() {
        // TODO returns the color of the space
        return null;
    }

}
