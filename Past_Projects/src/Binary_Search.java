import java.util.Arrays;
import java.util.Scanner;
/**
 * Return index of key within array using binary search
 */
public class Binary_Search {
	
	
	public static <T extends Comparable<? super T>> int iterativeBinSearch(T[] sortedArray,T key) {
		int left = 0;
		int right = sortedArray.length -1;
		int mid;
		while(left<=right) {
			mid = (left+right)/2;
			if(sortedArray[mid].equals(key)) {
				return mid;
			}
			else {
				if(key.compareTo(sortedArray[mid])<0) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
		}
		return -1;
	}
	
	
	
	public static <T extends Comparable<? super T>> int recurBinSearch(T[] sortedArray, T key) {
		return recurBinSearch(sortedArray,key,0,sortedArray.length-1);
	}
	
	private static <T extends Comparable<? super T>> int recurBinSearch(T[] sortedArray, T key, int left, int right) {
		if(left<=right) {
			int mid = (left+right)/2;
			if(sortedArray[mid].equals(key)) {
				return mid;
			}
			else {
				if(key.compareTo(sortedArray[mid])<0) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
				return recurBinSearch(sortedArray,key,left,right);
			}			
		}
		return -1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String[] arr1= {"a", "b", "c", "d", "e", "f"};
		System.out.println("The ordered list we are search through is: "+Arrays.toString(arr1));

		
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter a key to be searched in list: ");

	    String inputKey = sc.nextLine();
	    String key = inputKey;
	    System.out.println("Key entered was: " +key);
	    sc.close();
		
//		int a = iterativeBinSearch(orderedList,key);
//		if(a>=0) {System.out.println("Iterative Binary Search has not found the key " +key+ " in this list.");}
//		else{ System.out.println("Iterative Binary Search found that the key is at the index [" +a +"] within the list.");}
		
		int b = recurBinSearch(arr1,key);
		if(b<0) {System.out.println("Recursive Binary Search has not found the key " +key+ " in this list.");}
		else{
			System.out.println("Recursive Binary search found that the key is at the index [" +b +"] within the list.");
		}
	}

}

