public class Fib {
	
	static int basic_fib(int n) {
		if(n==0) return 0;
		if(n<=2) return 1;
		return (basic_fib(n-1))+(basic_fib(n-2));
	}
	
	static int topDown_fib(int n) {
		int memo[] = new int[n + 1];
		for(int i = 0; i < memo.length; i++){
			memo[i] = -1;
		}
		int r = recurHelper(n, memo);
		return r;
	} static int recurHelper(int n, int[] memo){
		if(n == 0) return 0;
		if(n == 1) return 1;
		if (memo[n] != -1) return memo[n];
		return recurHelper(n-1, memo) + recurHelper(n-2, memo);
	}
	
	static int bottomUp_fib(int n) {
		int f[] = new int[n+2];
		int i;
		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}

	static int tr_fib(int n) {
		return fiboTR(n, 0, 1);
	} static int fiboTR(int n, int a, int b) {
		if (n==0) return a;
		if (n==1) return b;
		return fiboTR(n - 1, b, a+b);
	}

	
	public static void main(String[] args) { // 0th = 0, 1, 1, 2, 4th=3, ...5702887,..., 44th = 701408733
		// Ranked by speed
		// bottomUp_fib(n);
		// tr_fib(n);
		// basic_fib(n);
		// topDown_fib(n);
		System.out.println("fn: 0,1,1,2,3,5,8,13,21,34,55,89,144,...");
		
		System.out.println("Starting from 0th");
		int n = 44;
		double start = System.nanoTime();
		int r = bottomUp_fib(n);
        double end = System.nanoTime();
        double duration = (end - start) / 1000000000; // execution time in seconds
		System.out.println(duration);
		System.out.println("The " +n +"th fibonacci number is " +r);


	}


}

