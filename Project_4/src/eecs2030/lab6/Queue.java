package eecs2030.lab6;

import java.util.NoSuchElementException;

/**
 * A classic first-in first-out queue data structure implemented as a linked
 * sequence of nodes.
 * 
 * @param <E>
 *            the type of element held in this queue
 */
public class Queue<E> {

	/**
	 * Queue uses a node based implementation, where the nodes form a singly
	 * linked-list like structure. The queue must maintain a reference to the
	 * node holding the element at the front of the queue, and a reference to
	 * the node holding the element at the end of the queue.
	 */

	/**
	 * The node at the front of the queue (the first node, or head, of the
	 * linked list).
	 */
	private Node<E> front;

	/**
	 * The node at the back of the queue (the last node of the linked list)
	 */
	private Node<E> back;

	/**
	 * The number of elements stored in this queue (or the number of nodes)
	 */
	private int size;

	/**
	 * Creates an empty queue (size is zero).
	 */
	public Queue() {

		this.size = 0;
	}

	/**
	 * Enqueue an element. This operation adds the element to the back of the
	 * queue.
	 * 
	 * @param element
	 *            the element to add to the back of the queue
	 */
	public void enqueue(E element) {
		Node<E> node = new Node<E>(element, null);
		if (this.size == 0) {
			this.front = node;

		} else {

			this.back.setNext(node);

		}
		this.back = node;
		this.size = this.size + 1;
	}

	/**
	 * Dequeue an element. This operation removes and returns the element at the
	 * front of the queue if the queue is not empty.
	 * 
	 * @return the element at the front of the queue if the queue is not empty
	 * @throws NoSuchElementException
	 *             if the queue is empty
	 */
	public E dequeue() {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		E n = this.front.getElement();
		this.front = this.front.getNext();
		this.size = this.size - 1;

		if (isEmpty())
			this.back = null;

		return n;
	}

	/**
	 * Return the element at the front of the queue without dequeuing the
	 * element.
	 * 
	 * @return the element at the front of the queue if the queue is not empty
	 * @throws NoSuchElementException
	 *             if the queue is empty
	 */
	public E peek() {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		E n = this.front.getElement();

		return n;
	}

	/**
	 * Returns the number of elements in this queue.
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if this queue is empty, and false otherwise.
	 * 
	 * @return true if this queue is empty, and false otherwise
	 */
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the node at the front of the queue. This method is here for
	 * debugging and testing purposes.
	 * 
	 * @return the node at the front of the queue
	 */
	Node<E> getFront() {
		return this.front;
	}

	/**
	 * Returns the node at the back of the queue. This method is here for
	 * debugging and testing purposes.
	 * 
	 * @return the node at the back of the queue
	 */
	Node<E> getBack() {
		return this.back;
	}

	/**
	 * Returns a hash code for this queue. The hash code is computed using the
	 * elements of this stack.
	 * 
	 * @return a hash code for this queue
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Node<E> n = this.front;
		while (n != null) {
			result = prime * result + n.getElement().hashCode();
			n = n.getNext();
		}
		return result;
	}

	/**
	 * Compares the specified object to this queue for equality. Two queues are
	 * equal if they contain the same number of elements in the same order.
	 * 
	 * @param obj
	 *            the object to compare to this queue for equality
	 * @return true if the specified object is equal to this queue
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Queue<E> other = (Queue<E>) obj;
		if (this.size == other.size()) {
			Node<E> n = this.front;
			Node<E> nOther = other.front;
			for (int i = 0; i < this.size; i++) {
				if (!n.getElement().equals(nOther.getElement())) {
					return false;
				}
				n = n.getNext();
				nOther = nOther.getNext();
			}
		}

		return true;
	}

	/**
	 * Returns a string representation of this queue. The string representation
	 * consists of a list of the queue's elements from the front of the queue to
	 * the back of the queue, enclosed in square brackets ("[]"). Adjacent
	 * elements are separated by the characters ", " (comma and space). Elements
	 * are converted to strings as by String.valueOf(Object).
	 * 
	 * @return a string representation of this queue
	 */
	@Override
	public String toString() {
		// see equals for an example of iterating over the nodes of the queue
		String s = "[";

		for (int i = 0; i < this.size; i++) {
			if (i == 0) {
				s = s + this.front.getElement();
				this.front = this.front.getNext();
			} else if (i == (this.size - 1)) {
				s = s + ", " + this.front.getElement();
			} else {
				s = s + ", " + this.front.getElement();
				this.front = this.front.getNext();
			}
		}
		s = s + "]";
		return s;
	}
}
