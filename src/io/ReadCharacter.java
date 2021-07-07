package io;

import character.GameCharacter;
import util.LinkedList;

import java.io.File;
import java.util.Scanner;

/**
 * Reads in data from a file and creates a list of GameCharacters.
 *
 * @author Zoë Hausmann
 */
public class ReadCharacter {
    /**
     * Reads in character data from file and adds it to the given character list.
     *
     * @param charList in-game list of characters
     * @param filename name of the file with character data
     * @throws Exception if an error occurs while reading character data from file
     */
    public static void main(LinkedList<GameCharacter> charList, String filename) throws Exception {
        try {
            // Check that file exists
            File file = new File(filename);
            Scanner in = new Scanner(file);
            // Read file in line by line
            String line;
            while(in.hasNextLine()) {
                line = in.nextLine();
                // Try to create a new character for each line
                GameCharacter temp;
                try {
                    temp = validateCharacter(line);
                } catch (Exception e) { throw new Exception(e.getMessage()); }
                charList.add(temp);
            }
        } catch (Exception e) { throw new Exception(e.getMessage()); }
    }

    /**
     * Creates a new GameCharacter from a line of character data.
     * Data must be separated by commas and be in the following format:
     * Name, Origin, Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma, PictureFilepath
     *
     * @param data line of character data
     * @return new GameCharacter created from file data
     * @throws Exception if error occurs creating character
     */
    public static GameCharacter validateCharacter(String data) throws Exception {
        // Create temporary character
        GameCharacter newChar;
        // Create scanner to read character data
        Scanner in;
        try { in = new Scanner(data); } catch (Exception e) {
            throw new Exception("Character could not be created.");
        }
        in.useDelimiter(",");

        // Get character name
        String name = in.next();    // Get character name
        String origin = in.next();  // Get character origin
        int[] stats = new int[6];   // Get character stats
        for (int i = 0; i < 6; i++) {
            int temp = in.nextInt();
            if (temp < 0 || temp > 5)
                throw new Exception("Invalid character stat value.");
            stats[i] = temp;
        }
        String profile = in.next(); // Get character image file
        if (!new File(profile).isFile())
            throw new Exception(name + "'s image file is invalid.");
        if(in.hasNext())
            throw new Exception("Invalid character data format.");
        // Create character
        newChar = new GameCharacter(name, origin, stats[0], stats[1], stats[2],
                stats[3], stats[4], stats[5], profile);
        in.close();
        return newChar;
    }

}
