package datastructures;

public class Stack<T> {

	private DoublyLinkedList<T> stack;

	public Stack() {
		stack = new DoublyLinkedList<T>();

	}

	public int getSize() {
		return stack.getSize();
	}

	public void push(T key) {
		stack.addLast(key);
	}

	public T pop() {
		return stack.removeLast();
	}

}
