package parallel;

import java.util.concurrent.atomic.AtomicIntegerArray;

/*
 * A process is required to take a numbered ticket with value greater than all outstanding tickets
 * CS Entry: Wait until ticket number is lowest
 */
public class BakeryLock {
	final int n;
	
	//acts as Boolean
	AtomicIntegerArray flag;
	AtomicIntegerArray label;
	
	public BakeryLock() {
		this(2);
	}
	
	public BakeryLock(int n) {
		this.n = n;
		flag = new AtomicIntegerArray(n);
		label = new AtomicIntegerArray(n);		
	}

	public void acquire(int me) {
		flag.set(me, 1);
		label.set(me, maxLabel()+1);
		
		while (conflict(me));
	}
	
	public void release(int me) {
		flag.set(me, 0);
	}
	
	int maxLabel() {
		int max = label.get(0);
		for (int i=1; i<n; i++) {
			max = Math.max(max, label.get(i));
		}
		return max;
	}
	
	boolean conflict(int me) {
		for (int i=0; i<n; i++) {
			if (i!=me && flag.get(i)!=0) {
				int diff = label.get(i) - label.get(me);
				
				if (diff < 0 || diff==0 && i<me) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
