import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * 
 * Heap that allows direct access the other elements through mapped keys
 *
 */

public class Idx_Heap<T, E extends Comparable<E>> { 
	private ArrayList<E>  heap; 
	private ArrayList<T>  keyList;     
	private int size;          
	private HashMap<T, Integer>  keyToIndex;
	private boolean min_heap;

	public Idx_Heap(T[] keyElements, E[] dataElements, boolean min){
		heap = new ArrayList<E>();
		heap.add(null);
		keyList = new ArrayList<T>();				   
		keyList.add(null);  	
		keyToIndex  = new HashMap<T,Integer>();
		size = 0;
		this.min_heap = min;
		for(T key : keyElements){
			for(E data : dataElements){
				add(key, data);
			}
		}
	}

	public Idx_Heap(boolean min){
		heap = new ArrayList<E>();
		heap.add(null);
		keyList = new ArrayList<T>();				   
		keyList.add(null);  	
		keyToIndex  = new HashMap<T,Integer>();
		size = 0;
		this.min_heap = min;
	}

	public boolean isEmpty() { return size == 0; }
	public int size() { return size; }

	private boolean hasParent(int i) {return i > 1;}
	private int parentIdx(int i) { return i/2; }
	private E parent(int i) { return heap.get(parentIdx(i)); }

	private boolean hasLeftChild(int i) { return leftIdx(i) <= size; }
	private int leftIdx(int i) { return 2*i; }
	private E left(int i) { return heap.get(leftIdx(i)); }

	private boolean hasRightChild(int i) { return rightIdx(i) <= size; }
	private int rightIdx(int i) { return (2*i)+1; }
	private E right(int i) { return heap.get(rightIdx(i)); }

	private boolean is_leaf(int i){ return (leftIdx(i) >= size) && (rightIdx(i) >= size); }
	private boolean hasOneChild(int i){ return (leftIdx(i) < size) && (rightIdx(i) >= size); }

	public boolean contains(T key) { return keyToIndex.containsKey(key); }

	public E get(T key){
		if (!contains(key)) { 
			throw new IllegalArgumentException(String.valueOf(key)+ " is not mapped to an element in the queue.");
		}
		return heap.get(keyToIndex.get(key));	
	}

	public E peek() { 
		if(size==0) { throw new IllegalStateException(); }
		return heap.get(1);
	}

	public T peekKey() { 
		if(size==0) { throw new IllegalStateException(); }
		return keyList.get(1);
	}

	private void swap(int idx1, int idx2) {
		T t1 = keyList.get(idx1);
		T t2 = keyList.get(idx2);
		keyToIndex.put( t1, Integer.valueOf(idx2));
		keyToIndex.put( t2, Integer.valueOf(idx1));

		E tmp1 = heap.get(idx2);
		heap.set(idx2, heap.get(idx1));
		heap.set(idx1, tmp1);	

		T tmp2 = keyList.get(idx2);
		keyList.set(idx2, keyList.get(idx1));
		keyList.set(idx1, tmp2);
	}

	public T poll() {
		if(size==0) { throw new IllegalStateException(); }

		T key = keyList.get(1);
		E removed = peek();

		if (size > 1){
			heap.set(1, heap.remove(size));   
			keyList.set(1, keyList.remove(size));
			keyToIndex.put(keyList.get(1), 1);
			size--;
			bubbleDown(1);
		}
		
		else {
			size--;
			heap.remove(1);
			keyList.remove(1);
		}
		
		keyToIndex.remove(key);   
		return key;
	}

	private void bubbleDown(int idx) {
		
		if(min_heap) {
			while(hasLeftChild(idx)) {
				int smallerChild_Idx = leftIdx(idx);
				if(hasRightChild(idx) && (left(idx).compareTo(right(idx)) > 0) ) {
					smallerChild_Idx = rightIdx(idx);
				}
				if( heap.get(idx).compareTo(heap.get(smallerChild_Idx)) < 0) { break; }
				else { swap(idx, smallerChild_Idx); }
				idx = smallerChild_Idx;
			}

		}

		else {
			while(hasLeftChild(idx)) {
				int smallerChild_Idx = leftIdx(idx); 
				if(hasRightChild(idx) && ( left(idx).compareTo(right(idx)) < 0) ) {
					smallerChild_Idx = rightIdx(idx);
				}
				if(heap.get(idx).compareTo( heap.get(smallerChild_Idx)) > 0) { break; }
				else { swap(idx, smallerChild_Idx); }
				idx = smallerChild_Idx;
			}
		}
	}
	
	public void add(T key, E pElement){
		if (contains(key)) {
			throw new IllegalArgumentException("The key " +String.valueOf(key)+ " is already present.");
		}
		heap.add(pElement);
		keyList.add(key);
		size++;
		keyToIndex.put(key, size);
		bubbleUp(size);
	}
	
	private void bubbleUp(int idx) {
		if(min_heap) {
			while(hasParent(idx) && (parent(idx).compareTo( heap.get(idx)) > 0 ) ) {  
				swap(parentIdx(idx), idx);
				idx = parentIdx(idx);
			}
		}
		else {
			while(hasParent(idx) && (parent(idx).compareTo( heap.get(idx)) < 0) ) {
				swap(parentIdx(idx), idx);
				idx = parentIdx(idx);
			}
		}
	}
	
	
	public void changePriority(T key, E pElement){
		if (!contains(key)) {
			throw new IllegalArgumentException(String.valueOf(key)+ " is not mapped to an element in the queue.");
		}
		int idx = keyToIndex.get(key);
		
		if(min_heap) {
			if (pElement.compareTo(heap.get(idx)) < 0){
				heap.set(idx, pElement);
				bubbleUp(idx);
			}
			else if (pElement.compareTo(heap.get(idx)) > 0){
				heap.set(idx, pElement );
				bubbleDown(idx);
			}
		}
		else {
			if (pElement.compareTo(heap.get(idx)) > 0){
				heap.set(idx, pElement);
				bubbleUp(idx);
			}
			else if (pElement.compareTo(heap.get(idx)) < 0){
				heap.set(idx, pElement );
				bubbleDown(idx);
			}
		}
	}
	
	private void bubblify(int n, int i) {
		int biggest = i;
		int l = leftIdx(i);
		int r = rightIdx(i);

		if (l < n && (left(i).compareTo(heap.get(biggest)) > 0) )
			biggest = l;

		if (r < n && (right(i).compareTo(heap.get(biggest)) > 0) )
			biggest = r;

		if (biggest != i) {
			swap(i, biggest);
			bubblify(n, biggest);
		}
	}
	
	void buildHeap(E arr[], int n) {
		int startIdx = (n / 2) - 1;
		heap = new ArrayList<E>(Arrays.asList(arr));
		for (int i = startIdx; i >= 0; i--) {
			bubblify(n, i);
		}
	}


	@Override
	public String toString() {
		return "Idx_Heap: [ " + heap + " ]";
	}


}
