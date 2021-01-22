package datastructures;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T >{

	Node<T> first;
	Node<T> last;

	private int size;

	public DoublyLinkedList() {	}

	public boolean isEmpty() {
		return size==0;
	}

	public Node<T> getNode(int index) {
		if (isEmpty()||index>=size) return null;

		if (index==size-1) return last;

		Node<T> cur = first;

		for (int i=0;i<index;i++) {
			cur = cur.getNext();
		}

		return cur;
	}

	public T get(int index) {
		Node<T> node = getNode(index); 

		if (node==null) return null;

		return node.getKey();
	}

	public void set(int index, T key) {
		Node<T> node = getNode(index); 

		if (node==null) return;

		node.setKey(key);

	}

	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}
	public void addFirst(T key) {
		Node<T> newNode = new Node<T>(key);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			newNode.setNext(first);
			first.setPrev(newNode);
			first = newNode;
		}

		size++;
	}

	public void addLast(T key) {
		Node<T> newNode = new Node<T>(key);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			newNode.setPrev(last);
			last = newNode;
		}

		size++;
	}

	public T removeFirst() {
		if (isEmpty()) return null;

		Node<T> toRemove = first;

		if (size==1) {
			clear();
		} else {
			first = first.getNext();
			first.setPrev(null);

			size--;
		}


		return toRemove.getKey();

	}

	public T removeLast() {
		if (isEmpty()) return null;

		Node<T> toRemove = last;

		if (size==1) {
			clear();
		} else {
			last = last.getPrev();
			last.setNext(null);

			size--;
		}	

		return toRemove.getKey();

	}

	public void addFromArray(T[] array) {

		for (int i=0;i<array.length;i++) {
			addLast(array[i]);
		}

	}

	public void addAll(DoublyLinkedList<T> list) {
		if (list.isEmpty()) return;

		if (isEmpty()) {
			first = list.getNode(0);
			last = list.getNode(list.getSize()-1);
		} else {
			last.setNext(list.getNode(0));
			list.getNode(0).setPrev(last);
			last = list.getNode(list.getSize()-1);
		}

		size += list.getSize();

	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[size];

		Node<T> cur = first;

		for (int i=0;i<size;i++) {
			array[i] = cur.getKey();
			cur = cur.getNext();
		}

		return array;  
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}

}
