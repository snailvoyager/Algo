package Sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		int instance = 0;
		int j=0;
		
		for(int i=1; i<n; i++) {
			instance = arr[i];				//���Ĵ��
			for(j=i-1; j>=0; j--) {			//���ĵ� ����, �����͸� ��ĭ�� �ڷ� �и鼭 ������ ��ġ�� ã�´� 
				if(arr[j] > instance)
					arr[j+1] = arr[j];		//�񱳴�� ��ĭ �ڷ� �б�
				else
					break;					//������ġ
			}
			arr[j+1] = instance;			//���Ĵ�� ����
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1,5};
		
		sort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

}
