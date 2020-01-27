package Sorting;

import java.util.Arrays;

import DataStructures.PriorityQueue.Heap;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		Heap heap = new Heap();
		for(int i=0; i<arr.length; i++) {		//Á¤·Ä´ë»ó Èü»ðÀÔ
			heap.insert(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++) {		//Á¤·Ä
			arr[i] = heap.delete();
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
