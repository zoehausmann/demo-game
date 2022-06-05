package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests LinkedList functionality.
 * @author Zoë Hausmann
 */
public class LinkedListTest {
	private final String str0 = "0"; // Test string object 0
	private final String str1 = "1"; // Test string object 1
	private final String str2 = "2"; // Test string object 2
	private final String str3 = "3"; // Test string object 3
	private final String str4 = "4"; // Test string object 4
	private final String str5 = "5"; // Test string object 5
	private final int int0 = 0; // Test integer object 0
	private final int int1 = 1; // Test integer object 1
	private final int int2 = 2; // Test integer object 2
	private final int int3 = 3; // Test integer object 3
	private final int int4 = 4; // Test integer object 4
	private final int int5 = 5; // Test integer object 5
	private LinkedList<String> strList; // Test string list
	private LinkedList<Integer> intList; // Test integer list

	/** Creates two empty LinkedLists, one for Strings and one for ints. */
	@Before
	public void setUp() {
		strList = new LinkedList<>();
		intList = new LinkedList<>();
	}

	/** Test method for LinkedList constructor. */
	@Test
	public void testLinkedList() {
		try {
			strList = new LinkedList<>();
			intList = new LinkedList<>();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/** Test method for generic add. */
	@Test
	public void testAddGeneric() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add to empty list
		strList.add(str0);
		intList.add(int0);
		assertEquals(str0, strList.get(0));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add to non-empty list
		strList.add(str1);
		intList.add(int1);
		assertEquals(str0, strList.get(0));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(int1, (int) intList.get(1));
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());
	}

	/** Test method for adding at an index. */
	@Test
	public void testAddAtIndex() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add to empty lists
		strList.add(0, str1);
		intList.add(0, int1);
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add first
		strList.add(0, str0);
		intList.add(0, int0);
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Add last
		strList.add(2, str3);
		intList.add(2, int3);
		assertEquals(3, strList.size());
		assertEquals(3, intList.size());

		// Add in middle
		strList.add(2, str2);
		intList.add(2, int2);
		assertEquals(4, strList.size());
		assertEquals(4, intList.size());

		// Check list items
		assertEquals(str0, strList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(str2, strList.get(2));
		assertEquals(str3, strList.get(3));

		// Add out of bounds
		try {
			strList.add(-1, str4);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.add(-1, int4);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			strList.add(5, str4);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.add(5, int4);
			fail();
		} catch (Exception e) {
			// Test passes
		}
	}

	/** Test method for addFirst. */
	@Test
	public void testAddFirst() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add first to empty list
		strList.addFirst(str1);
		intList.addFirst(int1);
		assertEquals(str1, strList.get(0));
		assertEquals(int1, (int) intList.get(0));
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add first to non-empty list
		strList.addFirst(str0);
		intList.addFirst(int0);
		assertEquals(str0, strList.get(0));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(int1, (int) intList.get(1));
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());
	}

	/** Test method for addLast. */
	@Test
	public void testAddLast() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add last to empty lists
		strList.addLast(str0);
		intList.addLast(int0);
		assertEquals(str0, strList.get(0));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add last to non-empty lists
		strList.addLast(str1);
		intList.addLast(int1);
		assertEquals(str0, strList.get(0));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(int1, (int) intList.get(1));
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());
	}

	/** Test method for getFirst. */
	@Test
	public void testGetFirst() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Get first from empty list
		try {
			strList.getFirst();
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.getFirst();
			fail();
		} catch (Exception e) {
			// Test passes
		}

		// Add one to list and get first
		strList.add(str1);
		intList.add(int1);
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
		assertEquals(str1, strList.getFirst());
		assertEquals(int1, intList.getFirst());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add different item at head and get first
		strList.addFirst(str0);
		intList.addFirst(int0);
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());
		assertEquals(str0, strList.getFirst());
		assertEquals(int0, intList.getFirst());
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Remove item from head and get first
		strList.removeFirst();
		intList.removeFirst();
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
		assertEquals(str1, strList.getFirst());
		assertEquals(int1, intList.getFirst());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
	}

	/** Test method forgetLast. */
	@Test
	public void testGetLast() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Get last from empty list
		try {
			strList.getLast();
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.getLast();
			fail();
		} catch (Exception e) {
			// Test passes
		}

		// Add one to list and get first
		strList.add(str0);
		intList.add(int0);
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
		assertEquals(str0, strList.getLast());
		assertEquals(int0, intList.getLast());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Add different item at tail and get last
		strList.addLast(str1);
		intList.addLast(int1);
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());
		assertEquals(str1, strList.getLast());
		assertEquals(int1, intList.getLast());
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Remove item from tail and get last
		strList.removeLast();
		intList.removeLast();
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
		assertEquals(str0, strList.getFirst());
		assertEquals(int0, intList.getFirst());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());
	}

	/** Test method for get. */
	@Test
	public void testGet() {
		// Create lists and checks that they are empty
		setUp();
		assertEquals(strList.size(), 0);
		assertEquals(intList.size(), 0);

		// Get from empty list
		try {
			strList.get(1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.get(1);
			fail();
		} catch (Exception e) {
			// Test passes
		}

		// Adds objects to empty lists
		strList.add(str0);
		strList.add(str1);
		strList.add(str2);
		assertEquals(strList.size(), 3);
		intList.add(int0);
		intList.add(int1);
		intList.add(int2);
		assertEquals(intList.size(), 3);

		// Get the first, middle, and last objects
		assertEquals(str0, strList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(str2, strList.get(2));
		assertEquals(strList.size(), 3);
		assertEquals(int0, (int) intList.get(0));
		assertEquals(int1, (int) intList.get(1));
		assertEquals(int2, (int) intList.get(2));
		assertEquals(intList.size(), 3);

		// Get out of bounds
		try {
			strList.get(-1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.get(-1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			strList.get(3);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.get(3);
			fail();
		} catch (Exception e) {
			// Test passes
		}
	}

	/** Test method for remove. */
	@Test
	public void testRemove() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add to empty lists
		strList.add(str0);
		strList.add(str1);
		strList.add(str2);
		strList.add(str3);
		intList.add(int0);
		intList.add(int1);
		intList.add(int2);
		intList.add(int3);
		assertEquals(4, strList.size());
		assertEquals(4, intList.size());

		// Check list items
		assertEquals(str0, strList.get(0));
		assertEquals(str1, strList.get(1));
		assertEquals(str2, strList.get(2));
		assertEquals(str3, strList.get(3));
		assertEquals(int0, (int) intList.get(0));
		assertEquals(int1, (int) intList.get(1));
		assertEquals(int2, (int) intList.get(2));
		assertEquals(int3, (int) intList.get(3));

		// Remove out of bounds
		try {
			strList.remove(-1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.remove(-1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			strList.remove(4);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.remove(4);
			fail();
		} catch (Exception e) {
			// Test passes
		}

		// Remove from middle
		assertEquals(str1, strList.remove(1));
		assertEquals(int1, intList.remove(1));
		assertEquals(3, strList.size());
		assertEquals(3, intList.size());

		// Remove first
		assertEquals(str0, strList.remove(0));
		assertEquals(int0, intList.remove(0));
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Remove last
		assertEquals(str3, strList.remove(1));
		assertEquals(int3, intList.remove(1));
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Remove only
		assertEquals(str2, strList.remove(0));
		assertEquals(int2, intList.remove(0));
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());
	}

	/** Test method for removeFirst. */
	@Test
	public void testRemoveFirst() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add items to list
		strList.add(str0);
		strList.add(str1);
		intList.add(int0);
		intList.add(int1);
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Remove first from list with multiple items
		assertEquals(str0, strList.removeFirst());
		assertEquals(int0, intList.removeFirst());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Remove first from list with one item
		assertEquals(str1, strList.removeFirst());
		assertEquals(int1, intList.removeFirst());
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Remove first from empty list
		try {
			strList.removeFirst();
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.removeFirst();
			fail();
		} catch (Exception e) {
			// Test passes
		}
	}

	/** Test method for removeLast. */
	@Test
	public void testRemoveLast() {
		// Create empty lists
		setUp();
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Add items to list
		strList.add(str0);
		strList.add(str1);
		intList.add(int0);
		intList.add(int1);
		assertEquals(2, strList.size());
		assertEquals(2, intList.size());

		// Remove last from list with multiple items
		assertEquals(str1, strList.removeLast());
		assertEquals(int1, intList.removeLast());
		assertEquals(1, strList.size());
		assertEquals(1, intList.size());

		// Remove last from list with one item
		assertEquals(str0, strList.removeLast());
		assertEquals(int0, intList.removeLast());
		assertEquals(0, strList.size());
		assertEquals(0, intList.size());

		// Remove first from empty list
		try {
			strList.removeLast();
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.removeLast();
			fail();
		} catch (Exception e) {
			// Test passes
		}
	}

	/** Test method for set. */
	@Test
	public void testSet() {
		// Create lists and checks that they are empty
		setUp();
		assertEquals(strList.size(), 0);
		assertEquals(intList.size(), 0);

		// Adds objects to empty lists
		strList.add(str3);
		strList.add(str4);
		strList.add(str5);
		assertEquals(strList.size(), 3);
		intList.add(int3);
		intList.add(int4);
		intList.add(int5);
		assertEquals(intList.size(), 3);

		// Sets the first, middle, and last objects
		strList.set(0, str0);
		strList.set(1, str1);
		strList.set(2, str2);
		assertEquals(strList.size(), 3);
		intList.set(0, int0);
		intList.set(1, int1);
		intList.set(2, int2);
		assertEquals(intList.size(), 3);

		// Checks that objects were properly set
		assertEquals(strList.getFirst(), str0);
		assertEquals(strList.get(1), str1);
		// assertEquals(strList.getLast(), str2);
		assertEquals(intList.getFirst(), int0);
		assertEquals(int1, (int) intList.get(1));
		assertEquals(intList.getLast(), int2);

		// Create new lists and try set on empty lists
		setUp();
		try {
			strList.set(0, str0);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.set(0, int0);
			fail();
		} catch (Exception e) {
			// Test passes
		}

		// Add items to lists and try to set out of bounds
		strList.add(str0);
		intList.add(int0);
		try {
			strList.set(-1, str1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.set(-1, int1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			strList.set(1, str1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
		try {
			intList.set(1, int1);
			fail();
		} catch (Exception e) {
			// Test passes
		}
	}

	/** Test method for testSize. */
	@Test
	public void testSize() {
		try {
			// Create lists and check that they are empty
			strList = new LinkedList<>();
			intList = new LinkedList<>();
			assertEquals(strList.size(), 0);
			assertEquals(intList.size(), 0);

			// Add object to empty list and check size
			strList.add(str2);
			assertEquals(strList.size(), 1);
			intList.add(int2);
			assertEquals(intList.size(), 1);

			// Add object to end of list and check size
			strList.addLast(str4);
			assertEquals(strList.size(), 2);
			intList.addLast(int4);
			assertEquals(intList.size(), 2);

			// Add object to beginning of list and check size
			strList.addFirst(str1);
			assertEquals(strList.size(), 3);
			intList.addFirst(int1);
			assertEquals(intList.size(), 3);

			// Add object at index in the middle of the list and check size
			strList.add(2, str3);
			assertEquals(strList.size(), 4);
			intList.add(2, int3);
			assertEquals(intList.size(), 4);

			// Add object at index at the beginning of the list and check size
			strList.add(0, str0);
			assertEquals(strList.size(), 5);
			intList.add(0, int0);
			assertEquals(intList.size(), 5);

			// Add object at index at the beginning of the list and check size
			strList.add(4, str5);
			assertEquals(strList.size(), 6);
			intList.add(4, int5);
			assertEquals(intList.size(), 6);


		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}