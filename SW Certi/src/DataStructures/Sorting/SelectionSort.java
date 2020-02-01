package DataStructures.Sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int arr[]) {
		int n = arr.length;
		int maxIdx = 0;
		int temp = 0;
		
		for(int i=0; i<n-1; i++) {
			maxIdx = i;
			for(int j=i+1; j<n; j++) {	//최솟값 탐색, 앞에서 채워가기 때문에 i 다음부터 비교
				if(arr[maxIdx] > arr[j]) {	//최솟값의 인덱스를 변경
					maxIdx = j;
				}
			}
			temp = arr[i];				//데이터 교환
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
