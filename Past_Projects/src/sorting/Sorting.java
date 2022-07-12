package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Sorting {
	
	public static boolean desc = true;

	public static <T extends Comparable<? super T>> T[] quicksort(T[] a){
		return quicksort_recur(a,0,a.length-1);
	}
	private static <T extends Comparable<? super T>> T[] quicksort_recur(T[] a, int left, int right){
		if(left>=right) {
			return a;
		}
		else {
			int i = placeAndDivide(a, left, right);
			quicksort_recur(a, left, i-1);
			quicksort_recur(a, i+1, right);
			return a;
		}
	}
	private static <T extends Comparable<? super T>> int placeAndDivide(T[] a, int left, int right){
		T pivot = a[right];
		int wall = left-1;
		for(int i= left; i<right; i++) {
			if(desc) {
				if(a[i].compareTo(pivot)>0) {
					wall++;
					swap(a, i, wall);
				}
			}
			else {
				if(pivot.compareTo(a[i])>0) {
					wall++;
					swap(a, i, wall);
				}
			}
		}
		swap(a, right, wall+1);
		return wall+1;
	}
	
	
	public static <T extends Comparable<? super T>> T[] mergesort(T[] a){
		List<T> l = new ArrayList<T>(Arrays.asList(a));
		return mergesort(l).toArray(a);
	}
	private static <T extends Comparable<? super T>> List<T> mergesort(List<T> list){
		if(list.size()==1) {
			return list;
		}
		else {
			int mid = (list.size()-1)/2;
			List<T> list1 = new ArrayList<T>();
			for(int i=0; i<=mid;i++) {
				list1.add(list.get(i));
			}
			List<T> list2 = new ArrayList<T>();
			for(int i=mid+1; i<list.size();i++) {
				list2.add(list.get(i));
			}
			list1=mergesort(list1);
			list2=mergesort(list2);
			return merge(list1,list2);
		}
	}
	public static <T extends Comparable<? super T>> List<T> merge(List<T> s1, List<T> s2){
		List<T> mergerList = new ArrayList<T>();
		while(!(s1.isEmpty())&&!s2.isEmpty()) {
			if(desc){
				if(s2.get(0).compareTo(s1.get(0))<0) {
					mergerList.add(s1.remove(0));
				}
				else {
					mergerList.add(s2.remove(0));
				}
			}
			else {
				if(s1.get(0).compareTo(s2.get(0))<0) {
					mergerList.add(s1.remove(0));
				}
				else {
					mergerList.add(s2.remove(0));
				}
			}
		}
		while(!s1.isEmpty()) {
			mergerList.add(s1.remove(0));
		}
		while(!s2.isEmpty()) {
			mergerList.add(s2.remove(0));
		}
		return mergerList;
	}


	
	public static <T extends Comparable<? super T>> T [] bubblesort(T [] a) {
		int n= a.length;
		for(int i=0; i<n; i++) {
			boolean sorted= true;
			for(int j=0; j<n-1-i; j++) {
				if(desc) {
					if(a[j].compareTo(a[j+1])<0) {
						swap(a,j, j+1);
						sorted=false;
					}
				}
				else { 
					if(a[j+1].compareTo(a[j])<0) {
						swap(a,j, j+1);
						sorted=false;
					}
				}
			}
			
			if(sorted) {
				break;
			}
		}
		return a;
	}

	public static <T extends Comparable<? super T>> T [] selectionsort(T[] a) {
		int n= a.length;
		for(int i=0; i<n-1; i++) { 
			T s= a[i];
			int sIndex=i;
			for(int j=i+1; j<n; j++) {
				if(desc) {
					if(s.compareTo(a[j])<0) {
						s=a[j];
						sIndex=j;
					}
				}
				else {
					if(a[j].compareTo(s)<0) {
						s=a[j];
						sIndex=j;
					}
				}
			}
			if(sIndex!=i) {
			swap(a,sIndex,i);
			}
		}
		return a;
	}
	
	private static <T extends Comparable<? super T>> void swap(T [] a, int x, int y) {
		T temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static <T extends Comparable<? super T>> void insertionsort(T[] a) {
		int n= a.length;
		for(int i=1; i<n; i++) {
			T e = a[i];
			int p;
			for(p=i;p>0;p--) {
				if(desc){
					if(a[p-1].compareTo(e)<0) {
						a[p]=a[p-1];
					}
					else {  
						break;
					}
				}
				else {
					if(e.compareTo(a[p-1])<0) {
						a[p]=a[p-1];
					}
					else {  
						break;
					}
				}
			}
			a[p]=e;
		}
		
	}
	
	
	
	
}
