package datastructures;

public class MinHeap<T extends Comparable<? super T>> extends Heap<T> {

	public MinHeap() {
	}

	protected boolean isInWrongOrder(int i, int j) {
		int c = compare(i, j);
		return c>0;
	}
	
}
