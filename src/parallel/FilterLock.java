package parallel;

import java.util.concurrent.atomic.AtomicIntegerArray;

//extension of PetersonLock to n processes

/*
 * Every thread t knows its level in the filter level[t]
 * In order to enter CS, a thread has to elevate all levels.
 * For each level, we use Peterson’s mechanism to filter at most one thread, if other threads are at higher level.
 * For every level l there is one victim victim[l] that has to let others pass in case of conflicts.
 */
public class FilterLock {
	volatile int n;
	AtomicIntegerArray level;
	AtomicIntegerArray victim;
	
	public FilterLock() {
		this(2);
	}
	
	public FilterLock(int n) {
		this.n = n;
		level = new AtomicIntegerArray(n);
		victim = new AtomicIntegerArray(n);
	}

	//∃k!=me: level[k]>=i
	boolean others(int me, int lev) {
		for (int k=0; k<n; k++) {
			if (k!=me && level.get(k)>=lev) return true;
		}
		return false;
	}
	
	public void acquire(int me) {
		for (int lev=1; lev<n; lev++) {
			level.set(me, lev);
			victim.set(lev, me);
			// other threads are at same or higher level
			// and I have to wait
			while(me==victim.get(lev) && others(me, lev));
		}
	}
	
	public void release(int me) {
		level.set(me, 0);
	}
	
}
