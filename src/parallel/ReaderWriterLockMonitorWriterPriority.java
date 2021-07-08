package parallel;


// unfair, with strong priority to writers
public class ReaderWriterLockMonitorWriterPriority implements ReaderWriterLock {

	int writers = 0;
	int readers = 0;
	
	int writersWaiting = 0;
	
	@Override
	public synchronized void acquireWrite() {
		writersWaiting++;
		while(writers > 0 || readers > 0) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		writersWaiting--;
		
		writers++;
	}

	@Override
	public synchronized void releaseWrite() {
		writers--;
		notifyAll();	
	}

	@Override
	public synchronized void acquireRead() {
		while(writers > 0 || writersWaiting > 0) {
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
