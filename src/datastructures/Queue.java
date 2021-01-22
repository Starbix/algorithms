package datastructures;

public class Queue<T> {

	private DoublyLinkedList<T> queue;

	public Queue() {
		queue = new DoublyLinkedList<T>();

	}

	public int getSize() {
		return queue.getSize();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public void enqueue(T key) {
		queue.addFirst(key);
	}

	public T dequeue() {
		return queue.removeLast();
	}
}
