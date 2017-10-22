/**
 * 
 */
package cs240_hmwk3;

/**
 * @author bjhau
 *
 */
public class SingleLinkedDequeue<T> implements DequeInterface<T> {

	private Node<T> head; // pointer to beginning of line
	private Node<T> tail; // pointer to end of line

	public SingleLinkedDequeue() {
		head = null;
		tail = null;
	}

	public SingleLinkedDequeue(Node<T> firstNode) {
		head = firstNode;
		tail = firstNode;
	}

	@SuppressWarnings("null")
	@Override
	public void addToBack(T newEntry) {
		Node<T> newNode = null;
		newNode.setData(newEntry);
		newNode.setLink(tail);
		tail = newNode;
	}

	/**
	 * Adds a new entry to the front/back of this dequeue.
	 * 
	 * @param newEntry
	 *            An object to be added
	 */
	@SuppressWarnings("null")
	@Override
	public void addToFront(T newEntry) {
		Node<T> newNode = null;
		newNode.setData(newEntry);
		newNode.setLink(null);
		head = newNode;
	}

	/**
	 * Removes all entries from this dequeue
	 */
	@Override
	public void clear() {
		Node<T> clearNode = tail;

		while (tail.getLink() != head) {
			tail.setData(null);
			tail = tail.getLink();
			clearNode.setLink(null);
			clearNode = tail;
		}
		clearNode.setData(null);
		clearNode.setLink(null);
	}

	@Override
	public T getBack() {
		if (!isEmpty()) {
			T tailData = tail.getData();
			return tailData;
		} else
			throw new EmptyQueueException();
	}

	/**
	 * Retrieves the from/back entry of this dequeue
	 * 
	 * @return The object at the front/back of the dequeue
	 * @throws EmptyQueueException
	 *             if the dequeue is empty before the operation
	 */
	@Override
	public T getFront() {
		if (!isEmpty()) {
			T headData = head.getData();
			return headData;
		} else
			throw new EmptyQueueException();
	}

	/**
	 * Detects whether this dequeue is empty
	 * 
	 * @return True is the dequeue is empty, or false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (head == tail) {
			return true;
		} else
			return false;
	}

	@Override
	public T removeBack() {
		if (!isEmpty()) {
			T tempData = tail.getData();
			Node<T> tempTail = tail.getLink();

			tail.setData(null);
			tail.setLink(null);
			tail = tempTail;

			return tempData;
		} else
			throw new EmptyQueueException();
		// check if data is there - if not throw exception
		// hold data in temp variable
		// delete data in DLNode - security
		// move head to next
		// ONLY IF there is a DLNode move its prev to null
	}

	/**
	 * Removes and returns the front/back entry of this dequeue.
	 * 
	 * @return The object at the front/back of the dequeue.
	 * @throws EmptyQueueException
	 *             if the dequeue is empty before the operation.
	 */
	@Override
	public T removeFront() {
		if (!isEmpty()) {
			T tempData = head.getData();
			Node<T> nextFront = tail;

			head.setData(null);
			while (nextFront != head) {
				nextFront = nextFront.getLink();
			}
			head = nextFront;
			head.setLink(null);

			return tempData;
		} else
			throw new EmptyQueueException();

		// check if data is in there - if not, throw exception
		// hold data in temp variable
		// delete data in DLNode - security
		// move head to next
		// ONLY IF there is a DLNode move its prev to null
	}

}
