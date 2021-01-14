package datastructures;

import java.util.ArrayList;

public abstract class Heap<T extends Comparable<? super T>> {

	protected ArrayList<T> list;
	
	private int size;
	
	public Heap() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<T>();
		size = 0;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public T extract() {
		if (isEmpty()) return null;
		T tmp = list.get(0);
		list.set(0, list.get(size-1));
		size--;
		restoreHeapCondition(0);
		return tmp;
	}
	
	public T find() {
		if (isEmpty()) return null;

		return list.get(0);
	}
	
	void restoreHeapCondition(int i) {
		int l = 2*i+1;
		int r = l+1;
		
		int m = i;
		
	
		
		if (l<size&&isInWrongOrder(i, l)) {
			//System.out.println(list.get(i)+"is wrong leftChild: "+list.get(l));
			m = l;
		}
		
		if (r<size&&isInWrongOrder(m,r)) {
			//System.out.println(list.get(r)+"is wrong sibling: "+list.get(m));
			m = r;
		}
		
		//swap is needed
		if (m!=i) {
			swap(m, i);
			restoreHeapCondition(m);
		}
		
	}

	int compare(int i, int j) {		
		return list.get(i).compareTo(list.get(j));
	}
	
	//Heap is maxHeap by default
	protected boolean isInWrongOrder(int i, int j) {
		int c = compare(i, j);
		return c<0;
	}
	
	private void swap(int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	public void addFromArray(T[] array) {
		for (int i=0;i<array.length;i++) {
			list.add(i, array[i]);
		}
		
		size += array.length;
		
		int half = size/2-1;
		
		System.out.println(half+": "+list.get(half));
		
		for (int i=half;i>=0;i--) {
			restoreHeapCondition(i);
		}
		
		
	}

	public T[] toArray() {		
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Comparable[size];
		
		for (int i=0;i<size;i++) {
			array[i] = list.get(i);
		}
 
		return array;
	}
	
	
}
