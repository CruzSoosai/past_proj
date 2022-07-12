/**
 * Given array of numbers
 * Get closest sum (no replacement) to target value, prefer higher number if tied
 */
public class Closest_Sum {

	private int target;

	public Closest_Sum(int target) {
		this.target = target;
	}

	public int value(int[] amounts) {
		int capacity = getSum(amounts);
		int [] DP = new int [capacity+1];
		DP[0] = 0;
		int bestValue = bf(amounts, DP,0, 0);
		return bestValue;
	}

	int bf(int [] amounts,int [] DP, int best, int cur) {
		if(DP[cur]!=0) {
			return DP[cur];
		}
		for (int i=0; i<amounts.length; i++) {
			if(amounts[i]!=-1) {
				if(cur>=target) {
					return cur;
				}
				cur=cur+amounts[i];
				best = check(best, cur);
				int temp = amounts[i];
				amounts[i]=-1;
				int with = bf(amounts,DP,best,cur);
				best=check(with, best);
				amounts[i]=temp;
				cur=cur-amounts[i];
				DP[cur]= best;
			}

		}
		return check(cur,best);

	}

	int check (int best, int cur) {
		if (Math.abs(target-cur)<=Math.abs(target-best)) {
			if(Math.abs(target-cur)==Math.abs(target-best)) {
				best = (cur>best) ? cur : best;
			}
			else {
				best = cur;
			}
		}
		return best;
	}

	private int getSum(int [] arr) {
		if( arr.length==0) {
			return -1;
		}
		int sum = arr [0];
		for (int i=1; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;	
	}

}
