package datastructures;

public class MaxHeap<T extends Comparable<? super T>> extends Heap<T> {

	public MaxHeap() {	}

	protected boolean isInWrongOrder(int i, int j) {
		int c = compare(i, j);
		return c<0;
	}
	
}
