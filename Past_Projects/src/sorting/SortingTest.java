package sorting;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SortingTest {
	
	String[]  a;
	Integer[]  b;
	String[]  a_copy;
	Integer[]  b_copy;
		
	
	@BeforeEach
	void setUp() {
		a = new String [] {"a", "j", "f", "z", "b"};
		a_copy = Arrays.copyOf(a, a.length);
		
		b = new Integer [] {7, 8, 10, 1, 5};
		b_copy = Arrays.copyOf(b, b.length);
		
	}
	
	
	@Test
	void test_quicksort_ascend() {
		Sorting.desc = false;
		
		Sorting.quicksort(a);
		Arrays.sort(a_copy);
		assertArrayEquals(a_copy,a);
		
		Sorting.quicksort(b);
		Arrays.sort(b_copy);
		assertArrayEquals(b_copy,b);
	}
	@Test
	void test_quicksort_descend() {
		Sorting.desc = true;
		
		Sorting.quicksort(a);
		Arrays.sort(a_copy, Collections.reverseOrder());
		assertArrayEquals(a_copy,a);
		
		Sorting.quicksort(b);
		Arrays.sort(b_copy, Collections.reverseOrder());
		assertArrayEquals(b_copy,b);
	}
	
	
	
	@Test
	void test_mergesort_ascend() {
		Sorting.desc = false;
		
		Sorting.mergesort(a);
		Arrays.sort(a_copy);
		assertArrayEquals(a_copy,a);
		
		Sorting.mergesort(b);
		Arrays.sort(b_copy);
		assertArrayEquals(b_copy,b);
	}
	@Test
	void test_mergesort_descend() {
		Sorting.desc = true;
		
		Sorting.mergesort(a);
		Arrays.sort(a_copy, Collections.reverseOrder());
		assertArrayEquals(a_copy,a);
		
		Sorting.mergesort(b);
		Arrays.sort(b_copy, Collections.reverseOrder());
		assertArrayEquals(b_copy,b);
	}
	
	
	
	@Test
	void test_bubblesort_ascend() {
		Sorting.desc = false;
		
		Sorting.bubblesort(a);
		Arrays.sort(a_copy);
		assertArrayEquals(a_copy,a);
		
		Sorting.bubblesort(b);
		Arrays.sort(b_copy);
		assertArrayEquals(b_copy,b);
	}
	@Test
	void test_bubblesort_descend() {
		Sorting.desc = true;
		
		Sorting.bubblesort(a);
		Arrays.sort(a_copy, Collections.reverseOrder());
		assertArrayEquals(a_copy,a);
		
		Sorting.bubblesort(b);
		Arrays.sort(b_copy, Collections.reverseOrder());
		assertArrayEquals(b_copy,b);
	}
	
	
	
	
	@Test
	void test_selectionsort_ascend() {
		Sorting.desc = false;
		
		Sorting.selectionsort(a);
		Arrays.sort(a_copy);
		assertArrayEquals(a_copy,a);
		
		Sorting.selectionsort(b);
		Arrays.sort(b_copy);
		assertArrayEquals(b_copy,b);
	}
	@Test
	void test_selectionsort_descend() {
		Sorting.desc = true;
		
		Sorting.selectionsort(a);
		Arrays.sort(a_copy, Collections.reverseOrder());
		assertArrayEquals(a_copy,a);
		
		Sorting.selectionsort(b);
		Arrays.sort(b_copy, Collections.reverseOrder());
		assertArrayEquals(b_copy,b);
	}
	
	
	
	@Test
	void test_insertionsort_ascend() {
		Sorting.desc = false;
		
		Sorting.insertionsort(a);
		Arrays.sort(a_copy);
		assertArrayEquals(a_copy,a);
		
		Sorting.insertionsort(b);
		Arrays.sort(b_copy);
		assertArrayEquals(b_copy,b);
	}
	@Test
	void test_insertionsort_descend() {
		Sorting.desc = true;
		
		Sorting.insertionsort(a);
		Arrays.sort(a_copy, Collections.reverseOrder());
		assertArrayEquals(a_copy,a);
		
		Sorting.insertionsort(b);
		Arrays.sort(b_copy, Collections.reverseOrder());
		assertArrayEquals(b_copy,b);
	}
	
}
