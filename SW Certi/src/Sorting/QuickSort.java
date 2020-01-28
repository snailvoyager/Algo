package Sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int[] arr, int left, int right) {
		if(left <= right) {
			int pivot = partition(arr, left, right);
			sort(arr, left, pivot-1);
			sort(arr, pivot+1, right);
		}
	}
	
	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];		//피벗은 가장 왼쪽
		int low = left + 1;
		int high = right;
		
		while(low <= high) {		//교차되지 않을 때까지 반복
			while(low <= right && pivot >= arr[low]) 		//피벗보다 큰 값을 찾는 과정
				low++;
			while(high >= (left+1) && pivot <= arr[high]) 	//피벗보다 작은 값을 찾는 과정
				high--;
			if(low <= high)				//교차되지 않은 상태면 swap
				swap(arr, low, high);
		}
		
		swap(arr, left, high);
		return high;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
