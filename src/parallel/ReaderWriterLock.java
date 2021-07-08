package parallel;

public interface ReaderWriterLock {
	
	public void acquireWrite();
	public void releaseWrite();
	
	public void acquireRead();
	public void releaseRead();
}
