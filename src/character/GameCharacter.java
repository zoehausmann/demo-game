package character;

/**
 * Maintains the data for a single in-game character.
 * @author Zoë Hausmann
 */
public class GameCharacter {
    /** Character name */
    private String name;
    /** Character origin */
    private String origin;
    /** Character's strength */
    int[] stats;
    /** Source file for character's picture */
    private String profile;
    /** Character's starting HP */
    private static int charHP;
    /** Character's current HP */
    private int hp;
    /** Starting HP for any character */
    private final int BASE_HP = 1000;

    /**
     * Creates a new character
     * @param name character's name
     * @param origin character's origin
     * @param str character's strength
     * @param dex character's dexterity
     * @param con character's constitution
     * @param ntl character's intelligence
     * @param wis character's wisdom
     * @param chr character's charisma
     */
    public GameCharacter(String name, String origin,
                         int str, int dex, int con,
                         int ntl, int wis, int chr, String file) {
        setName(name);
        setOrigin(origin);
        stats = new int[]{str, dex, con, ntl, wis, chr};
        setProfile(file);
        charHP = BASE_HP + get(Stat.STRENGTH); // Calculates character's starting HP
    }

    /**
     * Sets the Character's name.
     * @param name Character's name
     */
    private void setName(String name) { this.name = name; }

    /**
     * Sets the Character's origin.
     * @param origin Character's origin or entity
     */
    private void setOrigin(String origin) { this.origin = origin; }

    /**
     * Sets the location of the character's picture file.
     * @param pic location of the file for the character's picture
     */
    private void setProfile(String pic) {
        this.profile = pic;
    }

    /**
     * Returns character's name.
     * @return character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns character's origin.
     * @return character's origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Returns the value of the given type of stat.
     * @param type the stat to get the value of
     * @return value of the stat
     */
    public int get(Stat type) {
        return switch (type) {
            case STRENGTH -> stats[0];
            case DEXTERITY -> stats[1];
            case CONSTITUTION -> stats[2];
            case INTELLIGENCE -> stats[3];
            case WISDOM -> stats[4];
            case CHARISMA -> stats[5];
        };
    }

    /**
     * Reset's character's in-game hp
     */
    public void resetHP() {
        hp = charHP;
    }

    /**
     * Deducts from character's in-game hp
     * @param damage amount of damage to deduct from hp
     */
    public void deductHP(int damage) {
        hp -= damage;
    }

    public enum Stat {
        STRENGTH, // amount of HP dealt per attack
        DEXTERITY, // probability of evading?
        CONSTITUTION, // starting HP
        INTELLIGENCE, // ??
        WISDOM, // predict other moves?
        CHARISMA // reduction of damage taken from other player
    }
}