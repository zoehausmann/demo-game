package io;

import character.GameCharacter;
import org.junit.Before;
import org.junit.Test;
import util.LinkedList;

import static org.junit.Assert.*;

/**
 * Tests ReadCharacter functionality.
 * @author Zoë Hausmann
 */
public class ReadCharacterTest {
    private LinkedList<GameCharacter> charList; // List for storing newly created characters
    private final String invalidFile = "a";
    private final String file1 = "test-files/valid-file-1";
    private final String file2 = "test-files/invalid-file-1";
    private final String file3 = "test-files/invalid-file-2";
    private final String file4 = "test-files/invalid-file-3";
    private final String file5 = "test-files/invalid-file-4";

    /**
     * Resets character list.
     */
    @Before
    public void setUp() {
        charList = new LinkedList<>();
    }

    /**
     * Tests ReadCharacter functionality (and indirectly tests validateCharacter).
     */
    @Test
    public void readValidCharacterFile() {
        // Valid character file
        setUp();
        try {
            ReadCharacter.main(charList, file1);
        } catch (Exception e) { fail(); }
        assertEquals(3, charList.size());
        assertEquals("Alpha", charList.get(0).getName());
        assertEquals("Bravo", charList.get(1).getName());
        assertEquals("Charlie", charList.get(2).getName());



        // File with too much information

        // File with not enough fields

        // File with invalid image path

    }

    /**
     * Tests reading from invalid file.
     */
    @Test
    public void readInvalidFilePath() {
        setUp();
        try {
            ReadCharacter.main(charList, invalidFile);
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
            ReadCharacter.main(charList, file2);
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, charList.size());

        // File with invalid stat values (stat > 0)
        setUp();
        try {
            ReadCharacter.main(charList, file2);
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
        try {
            ReadCharacter.main(charList, file3);
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
            ReadCharacter.main(charList, file4);
            fail();
        } catch (Exception e) {
            // pass
        }
        assertEquals(0, charList.size());
    }

}