package Sorting;

import java.util.Arrays;

import DataStructures.Queue.CircularQueue;

public class RadixSort {
	final static int BUCKET_NUM = 10;		//10���� ��Ŷ 10��
	
	public static void sort(int[] arr, int num, int maxLen) {	//LSD���(Least Significant Digit)
		CircularQueue[] cQueue = new CircularQueue[BUCKET_NUM];	//ť �迭 ���
		for(int i=0; i<BUCKET_NUM; i++)
			cQueue[i] = new CircularQueue();
		
		int divfac = 1;
		
		for(int pos=0; pos<maxLen; pos++) {	//���� �� ������ ���̸�ŭ �ݺ�
			for(int di=0; di<num; di++) {	//���� ����� ����ŭ �ݺ�
				int radix = (arr[di] / divfac) % 10;	//N��° �ڸ��� ���� ����
				cQueue[radix].enqueue(arr[di]);		//��Ŷ�� ����
			}
			
			int di = 0;
			for(int bi=0; bi<BUCKET_NUM; bi++) {	//��Ŷ ����ŭ �ݺ�
				while(!cQueue[bi].isEmpty())
					arr[di++] = (int)cQueue[bi].dequeue();	//��Ŷ�� ����� �� ������ �ٽ� ����
			}
			divfac *= 10;	//N��° �ڸ��� ���� ������ ���� ������ ����
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {13, 212, 14, 7141, 10987, 6, 15};
		
		sort(arr, arr.length, 5);			//maxLen�� ���� �� �������� ���� ����
		
		System.out.println(Arrays.toString(arr));
	}

}
