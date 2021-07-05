package util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests LinkedList functionality.
 *
 * @author Zoe Hausmann
 */
public class LinkedListTest {
	private String str0 = "0"; // Test string object 0
	private String str1 = "1"; // Test string object 1
	private String str2 = "2"; // Test string object 2
	private String str3 = "3"; // Test string object 3
	private String str4 = "4"; // Test string object 4
	private String str5 = "5"; // Test string object 5
	private int int0 = 0; // Test integer object 0
	private int int1 = 1; // Test integer object 1
	private int int2 = 2; // Test integer object 2
	private int int3 = 3; // Test integer object 3
	private int int4 = 4; // Test integer object 4
	private int int5 = 5; // Test integer object 5
	private LinkedList strList; // Test string list
	private LinkedList intList; // Test integer list
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for LinkedList constructor.
	 */
	@Test
	public void testLinkedList() {
		try {
			strList = new LinkedList();
			intList = new LinkedList();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for add (generic and at an index).
	 */
	@Test
	public void testAdd() {
		try {
			strList = new LinkedList();
			if () {
				
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for addFirst.
	 */
	@Test
	public void testAddFirst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for addLast.
	 */
	@Test
	public void testAddLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getFirst.
	 */
	@Test
	public void testGetFirst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method forgetLast.
	 */
	@Test
	public void testGetLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for get.
	 */
	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for remove.
	 */
	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for removeFirst.
	 */
	@Test
	public void testRemoveFirst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for removeLast.
	 */
	@Test
	public void testRemoveLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for set.
	 */
	@Test
	public void testSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for testSize.
	 */
	@Test
	public void testSize() {
		try {
			// Create lists and check that they are empty
			strList = new LinkedList();
			intList = new LinkedList();
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
