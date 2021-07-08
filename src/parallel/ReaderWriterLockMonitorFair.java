package parallel;


// somewhat fair
public class ReaderWriterLockMonitorFair implements ReaderWriterLock {

	int writers = 0;
	int readers = 0;
	
	int writersWaiting = 0; //writers trying to enter CS
	int readersWaiting = 0; //readers trying to enter CS
	
	int writersWait = 0; //#readers the writers have to wait
	
	@Override
	public synchronized void acquireWrite() {
		writersWaiting++;
		while(writers > 0 || readers > 0 || writersWait > 0) {
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
		//after writing, let the number of waiting readers pass
		writersWait = readersWaiting;
		notifyAll();	
	}

	@Override
	public synchronized void acquireRead() {
		readersWaiting++;
							// writers are waiting and readers don't have priority
		while(writers > 0 || (writersWaiting > 0 || writersWait <= 0)) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		readersWaiting--;
		writersWait--;
		
		readers++;
	}

	@Override
	public synchronized void releaseRead() {
		readers--;
		notifyAll();
	}

}
