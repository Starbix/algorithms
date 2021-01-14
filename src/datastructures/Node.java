package datastructures;

public class Node<T> {

	private T key;
	
	private Node<T> prev;
	private Node<T> next;
	
	
	
	public T getKey() {
		return key;
	}



	public void setKey(T key) {
		this.key = key;
	}



	public Node<T> getPrev() {
		return prev;
	}



	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}



	public Node<T> getNext() {
		return next;
	}



	public void setNext(Node<T> next) {
		this.next = next;
	}

	
	public boolean hasNext() {
		return next!=null;
	}
	
	public Node<T> next() {
		return next;
	}


	public Node() {

	}
	
	public Node(T key) {
		setKey(key);
	}

}
