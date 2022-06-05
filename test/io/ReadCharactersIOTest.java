package io;

import io.ReadCharactersIO;
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
    private ArrayList<GameCharacter> charList; // List for storing newly created characters

    /**
     * Resets character list.
     */
    @Before
    public void setUp() {
        charList = new ArrayList<>();
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
            charList = ReadCharactersIO.readCharacters(validFile);
        } catch (Exception e) { fail(); }
        assertEquals(9, charList.size());
        assertEquals("Alpha", (charList.get(0)).getName());
        assertEquals("Bravo", charList.get(1).getName());
        assertEquals("Charlie", charList.get(2).getName());
        assertEquals("Delta", charList.get(3).getName());
        assertEquals("Echo", charList.get(4).getName());
        assertEquals("Foxtrot", charList.get(5).getName());
        assertEquals("Golf", charList.get(6).getName());
        assertEquals("Hotel", charList.get(7).getName());
        assertEquals("India", charList.get(8).getName());

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
        assertEquals(0, charList.size());
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
        assertEquals(0, charList.size());

        // File with invalid stat values (stat > 5)
        setUp();
        try {
            ReadCharactersIO.readCharacters("test-files/invalid-file-2");
            fail();
        } catch (Exception f) {
            // pass
        }
        assertEquals(0, charList.size());
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
        assertEquals(0, charList.size());
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
        assertEquals(0, charList.size());
    }
}