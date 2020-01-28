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
		int pivot = arr[left];		//�ǹ��� ���� ����
		int low = left + 1;
		int high = right;
		
		while(low <= high) {		//�������� ���� ������ �ݺ�
			while(low <= right && pivot >= arr[low]) 		//�ǹ����� ū ���� ã�� ����
				low++;
			while(high >= (left+1) && pivot <= arr[high]) 	//�ǹ����� ���� ���� ã�� ����
				high--;
			if(low <= high)				//�������� ���� ���¸� swap
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
