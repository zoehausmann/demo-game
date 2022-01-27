package gameplay;

import manager.GameManager;

public class Turn {
    /** Set list of moves chosen by the attacker at the beginning of the round */
    private Move[] attackPattern;
    /** Number of completely successful moves */
    int numSuccesses;
    /** Number of partially successful moves */
    int numPartial;
    /**
     * Returns the number of completely successful moves.
     * @return the number of completely successful moves
     */
    public int getSuccesses() {
        GameManager.
        return numSuccess;
    }

    /**
     * Returns the number of partially successful moves (correct move, incorrect position).
     * @return the number of partially successful moves (correct move, incorrect position)
     */
    public int partialSuccesses() { return numPartial; }
}
