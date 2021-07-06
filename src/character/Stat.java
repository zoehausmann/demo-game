package character;

/**
 * Maintains information for a character statistic.
 * @author Zoe Hausmann
 */
public class Stat {
    /** The six possible types of Character Stats. */
    public enum StatType {
        STRENGTH,
        DEXTERITY,
        CONSTITUTION,
        INTELLIGENCE,
        WISDOM,
        CHARISMA
    }

    /** Type of stat */
    StatType type;
    /** Value of the stat from 0-5 */
    private int value;

    /**
     * Creates a new stat with the given type and value.
     * @param type type of the stat
     * @param val value of the stat
     */
    public Stat(StatType type, int val) {
        setValue(val);
    }

    /**
     * Sets stat type.
     * @param typ type of the stat to be set
     */
    private void setType(StatType typ) { this.type = typ; }

    /**
     * Sets stat value.
     * @param val value of the stat to be set.
     */
    private void setValue(int val) { this.value = val; }
}
