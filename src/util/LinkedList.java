package util;

/**
 * Maintains a list of Objects.
 * 
 * @author Zoë Hausmann
 */
public class LinkedList {
	/** First Node in the list */
	private Node head;
	/** Last Node in the list */
	private Node tail;
	/** Size of the list. */
	private int size;
	
	/**
	 * Creates an empty list with head and tail pointers.
	 */
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param obj object to add to the list
	 */
	public void add(Object obj) {
		
	}
	
	/**
	 * Inserts an element at the given index.
	 * 
	 * @param index at which to add the object
	 * @param obj object to add to the list
	 */
	public void add(int index, Object obj) {
		
	}

	/**
	 * Adds an element to the beginning of the list.
	 * 
	 * @param obj object to add to the list
	 */
	public void addFirst(Object obj) {
		
	}
	
	/**
	 * Inserts an element at the end of the list.
	 * 
	 * @param obj element to add to the list
	 */
	public void addLast(Object obj) {
		
	}

	/**
	 * Returns the first element of the list.
	 * 
	 * @return the first element in the list
	 */
	public Object getFirst() {
		return null;
	}
	
	/**
	 * Returns the last element of the list.
	 * 
	 * @return the last element of the list
	 */
	public Object getLast() {
		return null;
	}
	
	/**
	 * Returns the element at the given index
	 * 
	 * @param index index of the object to get
	 * @return the object at the given index
	 */
	public Object get(int index) {
		return null;
	}
	
	/**
	 * Removes and returns the element at the given index.
	 *
	 * @param index index of the element to remove
	 * @return object that was removed
	 */
	public Object remove(int index) {
		return null;
	}
	
	/**
	 * Removes and returns the first element of the list.
	 *
	 * @return object that was removed
	 */
	public Object removeFirst() {
		return null;
	}
	
	/**
	 * Removes and returns the first element of the list.
	 *
	 * @return object that was removed
	 */
	public Object removeLast() {
		return null;
	}
	
	/**
	 * Replaces the element at the given index with the given object.
	 * Returns the object that was replaced.
	 * 
	 * @param index index of the object to be set
	 * @param obj new object
	 * @return object that was replaced
	 */
	public Object set(int index, Object obj) {
		return null;
	}
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		return 0;
	}

	
	/**
	 * Single node in a linked list.
	 */
	private class Node {
		/** Element contained in the Node */
		Object element;
		/** The next Node in the list */
		Node next;

		/**
		 * Creates a new Node with the given element and next node.
		 * @param obj
		 */
		Node(Object obj, Node next) {
			setElement(obj);
			setNext(next);
		}
		
		/**
		 * Sets the Node's element to the given object.
		 * 
		 * @param obj element to be set
		 */
		void setElement(Object obj) {
			this.element = obj;
		}
		
		/**
		 * Sets this Node's next field to point to the given Node.
		 * 
		 * @param next Node to point to
		 */
		void setNext(Node next) {
			this.next = next;
		}
	}

}
