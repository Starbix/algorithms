package parallel;

public class Semaphore {
	
	//one thread in critical section by default
	private int n = 1;

	public Semaphore() {
	}
	
	public Semaphore(int number) {
		n = number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void acquire() {
		acquire(1);
	}
	
	synchronized void acquire(int k) {
		while (n<=0) {
			try {
				wait();
			} catch (InterruptedException e) { };
		}
		n-=k;
	}

	void release() {
		release(1);
	}
	
	synchronized void release(int k) {
		n+=k;
		if (n>0) {
			notifyAll();
		}
	}

}
