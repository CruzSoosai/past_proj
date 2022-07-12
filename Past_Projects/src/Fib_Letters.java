import java.math.BigInteger;

/**
 * fib1 = A, fib2 = B, fibn = fibn-2 + fibn-1 where "+" is concatenation
 * A, B, AB, BAB, ABBAB, BABABBAB, ABBABBABABBAB, ...
 * Find N-th letter in the M-th string in the sequence.
 */

public class Fib_Letters {
	
	public static String fib_letter(int M, BigInteger N) {
		if(M==1) { return "A";}
		if(M==2) { return "B";}
		BigInteger[] f = new BigInteger[M+1];
		fib(M, f);
		String val = split(f,M-2,M-1,N);
		return val;
	}
	
	static String split(BigInteger[] f, int i, int j, BigInteger n) {
		if(i==2&&j==3) {
			if(n.equals(BigInteger.ONE)||n.equals(BigInteger.valueOf(3))) {
				return "B";
			}
			else {
				return "A";
			}
		}
		else if (i==1&&j==2) {
			if(n.equals(BigInteger.ONE)) {
				return "A";
			}
			else {
				return "B";
			}
		}
		else {
			if (n.compareTo(f[i])==1) {
			return split(f,j-2,j-1,n.subtract(f[i]));
			}
			else {
			return split(f,i-2,i-1,n);
			}
		}
	}

	static BigInteger fib(int m, BigInteger [] f) {
		f[0] = BigInteger.ZERO;
		f[1] = BigInteger.ONE;
		for (int i = 2; i <= m; i++){
        f[i] = f[i-1].add(f[i-2]);
        }
		return f[m];
	}

    public static void main(String[] args) {
    	// ABBABBAB<>A<>BBAB
		int M = 7;
		long n = 9L;
		BigInteger N = BigInteger.valueOf(n);
		String s = fib_letter(M, N);
		System.out.println(s);
	}

}

