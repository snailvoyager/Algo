package Sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] arr, int left, int right) {
		if(left < right) {		//left�� �۴ٴ� ���� �� ���� �� �ִٴ� ��
			int mid = (left + right) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int fIdx = left;						//�迭 �պκ� �ε���
		int rIdx = mid+1;						//�迭 �޺κ� �ε���
		int[] sortArr = new int[right+1];		//������ �����͸� ���� �迭
		int sIdx = left;						//���չ迭 �ε���
		
		while(fIdx <= mid && rIdx <= right) {	//�� ������ �����͸� ���Ͽ� ���չ迭�� ����
			if(arr[fIdx] <= arr[rIdx]) {		//�񱳿���
				sortArr[sIdx] = arr[fIdx];
				fIdx++;
			} else {
				sortArr[sIdx] = arr[rIdx];
				rIdx++;
			}
			sIdx++;
		}
		
		if(fIdx > mid) {			//�պκ��� ��� �Ű����ٸ�
			for(int i=rIdx; i<=right; i++, sIdx++) {		//�迭�� �޺κ� ���� ������ �״�� �ű��
				sortArr[sIdx] = arr[i];
			}
		} else {					//�޺κ��� ��� �Ű����ٸ�							
			for(int i=fIdx; i<=mid; i++, sIdx++) {			//�迭�� �պκ� ���� ������ �״�� �ű��
				sortArr[sIdx] = arr[i];
			}
		}
		
		for(int i=left; i<=right; i++) {
			arr[i] = sortArr[i];				//���� �迭 ����
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
