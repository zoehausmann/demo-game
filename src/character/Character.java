package character;

import util.LinkedList;

/**
 * Maintains the data for a single in-game character.
 * @author Zoë Hausmann
 */
public class Character {
    /** Character name */
    private String name;
    /** Character origin */
    private String origin;
    /** Character stats */
    private Stat[] stats;
    /** Source file for character's picture */
    private String profile;

    /**
     * Creates a new character
     * @param name character's name
     * @param origin character's origin
     * @param str character's strength
     * @param dex character's dexterity
     * @param cons character's constitution
     * @param intel character's intelligence
     * @param wis character's wisdom
     * @param chr character's charisma
     */
    public Character( String name, String origin,
                           int str, int dex, int cons,
                           int intel, int wis, int chr, String file) {
        setName(name);
        setOrigin(origin);
        stats[0] = new Stat(Stat.StatType.STRENGTH, str);
        stats[1] = new Stat(Stat.StatType.DEXTERITY, dex);
        stats[2] = new Stat(Stat.StatType.CONSTITUTION, cons);
        stats[3] = new Stat(Stat.StatType.INTELLIGENCE, intel);
        stats[4] = new Stat(Stat.StatType.WISDOM, wis);
        stats[5] = new Stat(Stat.StatType.CHARISMA, chr);
        setProfile(file);
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
}