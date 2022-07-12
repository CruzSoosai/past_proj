package sorting;
import java.util.Arrays;


public class Sorting_Print_Testing {

	public static void main(String[] args) {
		String[]  a = {"a", "j", "f", "z", "b"};
		Integer[]  b = {7, 8, 10, 1, 5};
		Sorting.desc = false;
		test_mergesort(b);
	}
	
	static <T extends Comparable<? super T>> void test_quicksort(T[] a) {
		System.out.println("Quicksort: ");
		System.out.println("Unsorted: " +Arrays.toString(a));
		Sorting.quicksort(a);
		System.out.println("Sorted: " +Arrays.toString(a));
		System.out.println();
	}
	
	
	static <T extends Comparable<? super T>> void test_mergesort(T[] a) {
		System.out.println("Mergesort: ");
		System.out.println("Unsorted: " +Arrays.toString(a));
		Sorting.mergesort(a);
		System.out.println("Sorted: " +Arrays.toString(a));
		System.out.println();
	}
	
	
	static <T extends Comparable<? super T>> void test_bubblesort(T[] a) {
		System.out.println("Bubblesort");
		System.out.println("Unsorted: " +Arrays.toString(a));
		Sorting.bubblesort(a);
		System.out.println("Sorted: " +Arrays.toString(a));
		System.out.println();
	}
	
	static <T extends Comparable<? super T>> void test_selectionsort(T[] a) {
		System.out.println("Selectionsort");
		System.out.println("Unsorted: " +Arrays.toString(a));
		Sorting.selectionsort(a);
		System.out.println("Sorted: " +Arrays.toString(a));
		System.out.println();
	}
	
	static <T extends Comparable<? super T>> void test_insertionsort(T[] a) {
		System.out.println("Insertionsort");
		System.out.println("Unsorted: " +Arrays.toString(a));
		Sorting.insertionsort(a);
		System.out.println("Sorted: " +Arrays.toString(a));
		System.out.println();
	}
}
