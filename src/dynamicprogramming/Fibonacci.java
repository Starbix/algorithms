package dynamicprogramming;

public class Fibonacci {

	public Fibonacci() {	}

	public static long fibonacci(int j) {
		long[] fib = new long[j+1];
		
		fib[1] = 1;
		fib[2] = 1;
		
		for (int i=3;i<=j;i++) {
			fib[i] = fib[i-1]+fib[i-2];
		}
		
		return fib[j];
		
	}
	
}
