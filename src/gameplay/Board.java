package gameplay;

/**
 * Maintains a 2D array of Spaces to represent the game board.
 * @author Zoë Hausmann
 */
public class Board {
    // CONSTANTS
    /** Number of columns (moves) */
    private int cols;
    /** Number of rows (turns) */
    private int rows;
    /** RGB space colors */
    private static final int[] DEFAULT_COLOR =  { 127, 127, 127 }; // Gray
    private static final int[] PUNCH_COLOR =    { 256,   0,   0 }; // Red
    private static final int[] KICK_COLOR =     {   0, 256,   0 }; // Green
    private static final int[] SPECIAL_COLOR =  {   0,   0, 256 }; // Blue
    private static final int[] DUCK_COLOR =     {   0, 256, 256 }; // Cyan
    private static final int[] JUMP_COLOR =     { 256,   0, 256 }; // Magenta
    private static final int[] BLOCK_COLOR =    { 256, 256,   0 }; // Yellow

    // VARIABLES
    /** Array representation of game board */
    private Space[][] board;

    // CONSTRUCTORS
    /**
     * Creates a new array representation of the game board.
     * @param turns the number of turns in the round
     * @param moves the number of moves in a turn
     * @throws IndexOutOfBoundsException if the number of turns or moves is invalid
     */
    public Board(int turns, int moves) {
        if (turns < 5 || turns > 18)
            throw new IndexOutOfBoundsException("Invalid number of turns");
        rows = turns;
        if (moves < 3 || moves > 5)
            throw new IndexOutOfBoundsException("Invalid number of moves");
        cols = moves;
        // Create a new board matrix
        board = new Space[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                board[r][c] = new Space();
            }
        }
    }

    /**
     * Changes space color/action based on given action.
     * @param act Action
     */
    public void setSpace(int turn, int move, Action act) {
        if (act == null)
            board[turn][move].deactivate();
        else
            board[turn][move].activate();
        board[turn][move].setAction(act);
    }

    /**
     * Returns the color associated with a given action.
     * @return the color associated with a given action
     */
    public static int[] getColor(Action act) {
        return switch (act) {
            case PUNCH -> (PUNCH_COLOR);
            case KICK -> (KICK_COLOR);
            case SPECIAL -> (SPECIAL_COLOR);
            case DUCK -> (DUCK_COLOR);
            case JUMP -> (JUMP_COLOR);
            case BLOCK -> (BLOCK_COLOR);
        };
    }

    /**
     * Maintains the color and action for a given space on the board.
     * @author Zoë Hausmann
     */
    private class Space {

        // VARIABLES
        /** True if space is currently used in gameplay */
        private boolean active;
        /** Type of action */
        private Action actionType;
        /** Color */
        private int[] color;

        // CONSTRUCTORS
        public Space() {
            this.active = false;
            this.actionType = null;
            this.color = Board.DEFAULT_COLOR;
        }

        // GETTERS AND SETTERS
        /** Sets the space to active */
        public void activate() { active = true; }

        /** Sets the space to inactive */
        public void deactivate() { active = false; }

        /**
         * Sets the action and color of the space.
         * @param act action type stored in the space
         */
        public void setAction(Action act) {
            this.actionType = act;
            this.color = (Board.getColor(act));
        }
    }
}
