package gameplay;

import java.util.ArrayList;

/**
 * Object representing one player Turn in the game.
 *
 * Created using the following resources:
 *
 * Code Java - How to make Editable JTable in Java Swing
 * https://www.codejava.net/java-se/swing/editable-jtable-example
 *
 * @author Zoë Hausmann
 */
public class Turn {
    /** Round number */
    private int roundNumber = 0;
    /** List containing Round label and actions */
    private ArrayList<String> actions;

    /**
     * Creates a new Turn object with a Round name and placeholder actions.
     * @param roundNumber round number
     */
    public Turn(int roundNumber) {
        this.roundNumber = roundNumber;
        actions = new ArrayList<String>();
        actions.add("Round " + roundNumber);
        for (int i = 1; i <= GLOBALS.ACTIONS; i++)
            actions.add("○");
        actions.add("");
    }

    /**
     * Gets the string value at the given index.
     * @param index index of the value to get
     * @return the value at the given index
     */
    public String getValueAt(int index) {
        return actions.get(index);
    }

    /**
     * Sets given value at given index.
     * @param value value to be set
     * @param index index of value to be set
     * @return the updated value at the given index
     */
    public String setValueAt(String value, int index) {
        actions.set(index, value);
        return actions.get(index);
    }

    /**
     * Returns the round number of the given Turn.
     * @return the round number of the given Turn
     */
    public int getRoundNumber() {
        return roundNumber;
    }
}