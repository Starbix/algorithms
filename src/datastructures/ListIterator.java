package datastructures;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {

	DoublyLinkedList<T> list;
	
	Node<T> node;
	
	public ListIterator(DoublyLinkedList<T> list) {
		this.list = list;
		node = list.getNode(0);
	}

	@Override
	public boolean hasNext() {
		return !(list.isEmpty()||node==null);
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		Node<T> tmp = node;
		
		node = node.getNext();
		return tmp.getKey();
	}

}
