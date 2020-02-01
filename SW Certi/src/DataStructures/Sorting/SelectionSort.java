package DataStructures.Sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int arr[]) {
		int n = arr.length;
		int maxIdx = 0;
		int temp = 0;
		
		for(int i=0; i<n-1; i++) {
			maxIdx = i;
			for(int j=i+1; j<n; j++) {	//�ּڰ� Ž��, �տ��� ä������ ������ i �������� ��
				if(arr[maxIdx] > arr[j]) {	//�ּڰ��� �ε����� ����
					maxIdx = j;
				}
			}
			temp = arr[i];				//������ ��ȯ
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
