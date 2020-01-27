package Sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		int instance = 0;
		int j=0;
		
		for(int i=1; i<n; i++) {
			instance = arr[i];				//정렬대상
			for(j=i-1; j>=0; j--) {			//정렬된 구간, 데이터를 한칸씩 뒤로 밀면서 삽입할 위치를 찾는다 
				if(arr[j] > instance)
					arr[j+1] = arr[j];		//비교대상 한칸 뒤로 밀기
				else
					break;					//삽입위치
			}
			arr[j+1] = instance;			//정렬대상 삽입
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
