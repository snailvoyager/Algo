package DataStructures.Sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void sort(int arr[]) {
		int n = arr.length;
		int temp = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<(n-i)-1; j++) {		//우선순위가 가장 낮은 값을 맨뒤부터 보내기 때문에 비교횟수가 줄어듬 
				if(arr[j] > arr[j+1]) {			//오름차순 정렬, 인접한 두개의 데이터 비교
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
