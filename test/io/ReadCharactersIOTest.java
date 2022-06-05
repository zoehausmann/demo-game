package io;

import character.GameCharacter;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests ReadCharactersIO functionality.
 * @author Zoë Hausmann
 */
public class ReadCharactersIOTest {
    private ArrayList<GameCharacter> characterList; // List for storing newly created characters

    /**
     * Resets character list.
     */
    @Before
    public void setUp() {
        characterList = new ArrayList<>();
    }

    /**
     * Tests ReadCharactersIO functionality (and indirectly tests validateCharacter).
     */
    @Test
    public void readValidCharacterFile() {
        // Valid character file
        setUp();
        try {
            String validFile = "test-files/valid-file-1";
            characterList = ReadCharactersIO.readCharacters(validFile);
        } catch (Exception e) { fail(); }
        assertEquals(9, characterList.size());
        assertEquals("Alpha", (characterList.get(0)).getName());
        assertEquals("Bravo", characterList.get(1).getName());
        assertEquals("Charlie", characterList.get(2).getName());
        assertEquals("Delta", characterList.get(3).getName());
        assertEquals("Echo", characterList.get(4).getName());
        assertEquals("Foxtrot", characterList.get(5).getName());
        assertEquals("Golf", characterList.get(6).getName());
        assertEquals("Hotel", characterList.get(7).getName());
        assertEquals("India", characterList.get(8).getName());

    }

    /**
     * Tests reading from invalid file.
     */
    @Test
    public void readInvalidFilePath() {
        setUp();
        try {
            String invalidFile = "a";
            ReadCharactersIO.readCharacters(invalidFile);
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, characterList.size());
    }

    /**
     * Tests reading in a file with invalid character stats.
     */
    @Test
    public void readInvalidStats() {
        // File with invalid stat values (stat < 0)
        setUp();
        try {
            ReadCharactersIO.readCharacters("test-files/invalid-file-1");
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, characterList.size());

        // File with invalid stat values (stat > 5)
        setUp();
        try {
            ReadCharactersIO.readCharacters("test-files/invalid-file-2");
            fail();
        } catch (Exception f) {
            // pass
        }
        assertEquals(0, characterList.size());
    }

    /**
     * Tests reading in a file with incomplete character information.
     */
    @Test
    public void readIncompleteFile() {
        setUp();
        // File with too few stat values
        try {
            ReadCharactersIO.readCharacters("test-files/invalid-file-3");
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, characterList.size());
    }

    /**
     * Tests reading in a file with extra character information.
     */
    @Test
    public void readExtraFile() {
        setUp();
        try {
            ReadCharactersIO.readCharacters("test-files/invalid-file-4");
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, characterList.size());
    }
}