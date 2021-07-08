package parallel;


// unfair
public class ReaderWriterLockMonitor implements ReaderWriterLock {

	int writers = 0;
	int readers = 0;
	
	@Override
	public synchronized void acquireWrite() {
		while(writers > 0 || readers > 0) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		
		writers++;
	}

	@Override
	public synchronized void releaseWrite() {
		writers--;
		notifyAll();	
	}

	@Override
	public synchronized void acquireRead() {
		while(writers > 0) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		
		readers++;
	}

	@Override
	public synchronized void releaseRead() {
		readers--;
		notifyAll();
	}

}
