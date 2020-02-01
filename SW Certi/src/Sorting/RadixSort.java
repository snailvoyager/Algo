package Sorting;

import java.util.Arrays;

import DataStructures.Queue.CircularQueue;

public class RadixSort {
	final static int BUCKET_NUM = 10;		//10진수 버킷 10개
	
	public static void sort(int[] arr, int num, int maxLen) {	//LSD방식(Least Significant Digit)
		CircularQueue[] cQueue = new CircularQueue[BUCKET_NUM];	//큐 배열 사용
		for(int i=0; i<BUCKET_NUM; i++)
			cQueue[i] = new CircularQueue();
		
		int divfac = 1;
		
		for(int pos=0; pos<maxLen; pos++) {	//가장 긴 데이터 길이만큼 반복
			for(int di=0; di<num; di++) {	//정렬 대상의 수만큼 반복
				int radix = (arr[di] / divfac) % 10;	//N번째 자리의 숫자 추출
				cQueue[radix].enqueue(arr[di]);		//버킷에 저장
			}
			
			int di = 0;
			for(int bi=0; bi<BUCKET_NUM; bi++) {	//버킷 수만큼 반복
				while(!cQueue[bi].isEmpty())
					arr[di++] = (int)cQueue[bi].dequeue();	//버킷에 저장된 것 꺼내서 다시 저장
			}
			divfac *= 10;	//N번째 자리의 숫자 추출을 위한 피제수 증가
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {13, 212, 14, 7141, 10987, 6, 15};
		
		sort(arr, arr.length, 5);			//maxLen은 가장 긴 데이터의 길이 정보
		
		System.out.println(Arrays.toString(arr));
	}

}
