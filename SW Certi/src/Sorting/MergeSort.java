package Sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] arr, int left, int right) {
		if(left < right) {		//left가 작다는 것은 더 나눌 수 있다는 뜻
			int mid = (left + right) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int fIdx = left;						//배열 앞부분 인덱스
		int rIdx = mid+1;						//배열 뒷부분 인덱스
		int[] sortArr = new int[right+1];		//병합할 데이터를 담을 배열
		int sIdx = left;						//병합배열 인덱스
		
		while(fIdx <= mid && rIdx <= right) {	//두 영역의 데이터를 비교하여 병합배열에 정렬
			if(arr[fIdx] <= arr[rIdx]) {		//비교연산
				sortArr[sIdx] = arr[fIdx];
				fIdx++;
			} else {
				sortArr[sIdx] = arr[rIdx];
				rIdx++;
			}
			sIdx++;
		}
		
		if(fIdx > mid) {			//앞부분이 모두 옮겨졌다면
			for(int i=rIdx; i<=right; i++, sIdx++) {		//배열의 뒷부분 남은 데이터 그대로 옮긴다
				sortArr[sIdx] = arr[i];
			}
		} else {					//뒷부분이 모두 옮겨졌다면							
			for(int i=fIdx; i<=mid; i++, sIdx++) {			//배열의 앞부분 남은 데이터 그대로 옮긴다
				sortArr[sIdx] = arr[i];
			}
		}
		
		for(int i=left; i<=right; i++) {
			arr[i] = sortArr[i];				//병합 배열 복사
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
