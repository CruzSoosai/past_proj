
import java.util.Random;

public class TestIdx_Heap {

	public static void main(String[] args) {

		Random generator = new Random();
		double d;

		Idx_Heap<String, Double>  pq = new Idx_Heap<String, Double>(false);

		int numElements = 5;
		for (int i=1; i <= numElements; i++) {
			d = generator.nextDouble();
			String s = "v_" + Integer.valueOf(i).toString();
			pq.add(s, d);
		}

		for (int i=1; i <= numElements; i++) {
			String s = "v_" + Integer.valueOf(i).toString();
			pq.changePriority(s, i*1.0);
		}
			
		System.out.println("\nRemoving all the elements (in order of priority) ");
		String    names[]      = new String[numElements]; 
		double    priorities[] = new double[numElements]; 
		for (int i=0; i < numElements; i++){
			priorities[i] = pq.peek();			
			names[i] = pq.poll();
		}

		for (int i=0; i < numElements; i++){
			System.out.println( String.valueOf(names[i]) + " " + String.valueOf(priorities[i])    );
		}
	}

}
