package DataStructures.Sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void sort(int arr[]) {
		int n = arr.length;
		int temp = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<(n-i)-1; j++) {		//�켱������ ���� ���� ���� �ǵں��� ������ ������ ��Ƚ���� �پ�� 
				if(arr[j] > arr[j+1]) {			//�������� ����, ������ �ΰ��� ������ ��
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
					
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
