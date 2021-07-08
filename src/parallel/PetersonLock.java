package parallel;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class PetersonLock {
	
	volatile int victim;
	AtomicIntegerArray flag = new AtomicIntegerArray(2);

	public void acquire(int id) {
		flag.set(id, 1);
		victim = id;
		while (flag.get(1-id)==1 && victim==id);
	}
	
	public void release(int id) {
		flag.set(id, 0);
	}

}
