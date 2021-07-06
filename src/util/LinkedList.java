package util;

/**
 * Maintains a serial list of Objects.
 * Supports adding, removing, getting, and setting objects in the list.
 * @author Zoë Hausmann
 */
public class LinkedList {
	/** Points to the first Node in the list. */
	private Node head;
	/** Points to the last Node in the list. */
	private Node tail;
	/** Size of the list. */
	private int size;
	
	/** Creates an empty list with head and tail pointers. */
	public LinkedList() {
		tail = new Node(null);
		head = new Node(null, tail);
		size = 0;
	}

	/**
	 * Adds an element to the end of the list.
	 * @param obj object to add to the list
	 */
	public void add(Object obj) {
		addLast(obj);
	}
	
	/**
	 * Inserts an element at the given index.
	 * @param index at which to add the object
	 * @param obj object to add to the list
	 */
	public void add(int index, Object obj) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		// Add to empty list
		if (size == 0) {
			head.next = new Node(obj);
			tail = head.next;
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++)
				temp = temp.next;
			temp.setNext(new Node(obj, temp.next));
			if (size == 1)
				tail = temp.next;
		}
		size++;
	}

	/**
	 * Adds an element to the beginning of the list.
	 * @param obj object to add to the list
	 */
	public void addFirst(Object obj) {
		Node temp = new Node(obj);
		temp.next = head.next;
		head.next = temp;
		if (size == 0)
			tail = head.next;
		size++;
	}
	
	/**
	 * Inserts an element at the end of the list.
	 * @param obj element to add to the list
	 */
	public void addLast(Object obj) {
		if (size == 0) {
			head.next = new Node(obj);
			tail = head.next;
		} else {
			tail.setNext(new Node(obj));
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Returns the first element of the list.
	 * @return the first element in the list
	 * @throws IndexOutOfBoundsException if list is empty
	 */
	public Object getFirst() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		return head.next.element;
	}
	
	/**
	 * Returns the last element of the list.
	 * @return the last element of the list
	 * @throws IndexOutOfBoundsException if list is empty
	 */
	public Object getLast() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		return tail.element;
	}
	
	/**
	 * Returns the element at the given index
	 * @param index index of the object to get
	 * @return the object at the given index
	 * @throws IndexOutOfBoundsException if no element exists at the given index
	 */
	public Object get(int index) {
		if (size == 0 || index < 0 || index >= size )
			throw new IndexOutOfBoundsException();

		Node temp = head.next;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		return temp.element;
	}
	
	/**
	 * Removes and returns the element at the given index.
	 * @param index index of the element to remove
	 * @return object that was removed
	 * @throws IndexOutOfBoundsException if no element exists at the given index
	 */
	public Object remove(int index) {
		if (size == 0 || index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object element;
		// if size is one, remove only element
		if (size == 1) {
			element = head.next.element;
			head.next = tail;
			tail.next = null;
		// else, traverse list and remove Node at index
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++)
				temp = temp.next;
			element = temp.next.element;
			temp.next = temp.next.next;
		}
		size--;
		return element;
	}
	
	/**
	 * Removes and returns the first element of the list.
	 * @return object that was removed
	 * @throws IndexOutOfBoundsException if no element exists at the given index
	 */
	public Object removeFirst() {
		Object element;
		try {
		 	element = remove(0);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
		return element;
	}
	
	/**
	 * Removes and returns the first element of the list.
	 * @return object that was removed
	 * @throws IndexOutOfBoundsException if no element exists at the given index
	 */
	public Object removeLast() {
		Object element;
		try {
			element = remove(size - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
		return element;
	}
	
	/**
	 * Replaces the element at the given index with the given object.
	 * Returns the object that was replaced.
	 * @param index index of the object to be set
	 * @param obj new object
	 * @return object that was replaced
	 * @throws IndexOutOfBoundsException if no element exists at the given index
	 */
	public Object set(int index, Object obj) {
		if (size == 0 || index < 0 || index >= size )
			throw new IndexOutOfBoundsException();

		Object element;
		Node temp = head.next;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		element = temp.element;
		temp.setElement(obj);
		if (index == size - 1)
			tail = temp;
		return element;
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return the number of elements in the list
	 */
	public int size() {
		return size;
	}

	
	/** Single node in a linked list. */
	private class Node {
		/** Element contained in the Node */
		Object element;
		/** The next Node in the list */
		Node next;

		/**
		 * Creates a new Node with the given element and next of null.
		 * @param obj the element stored in the Node
		 */
		Node(Object obj) {
			setElement(obj);
			setNext(null);
		}

		/**
		 * Creates a new Node with the given element and next node.
		 * @param obj the element stored in the Node
		 */
		Node(Object obj, Node next) {
			setElement(obj);
			setNext(next);
		}
		
		/**
		 * Sets the Node's element to the given object.
		 * @param obj element to be set
		 */
		void setElement(Object obj) {
			this.element = obj;
		}
		
		/**
		 * Sets this Node's next field to point to the given Node.
		 * @param next Node to point to
		 */
		void setNext(Node next) {
			this.next = next;
		}
	}

}
