package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ1269_BinarySearchTree {
	
	static int A, B;
	static int[] Arr, Brr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		Arr = new int[A];
		Brr = new int[B];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++){
			Arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++){
			Brr[i] = Integer.parseInt(st.nextToken());
		}
		
		TreeSet<Integer> treeA = new TreeSet<Integer>();
		for(int key : Arr)
			treeA.add(key);
		//System.out.println(treeA);
		
		TreeSet<Integer> treeB = new TreeSet<Integer>();
		for(int key : Brr)
			treeB.add(key);
		//System.out.println(treeB);
		
		//A-B
		int resultA = 0;
		for(int i=0; i<A; i++){
			if(!treeB.contains(Arr[i]))
				resultA++;
		}
		
		//B-A
		int resultB = 0;
		for(int i=0; i<B; i++){
			if(!treeA.contains(Brr[i]))
				resultB++;
		}
		
		System.out.println(resultA + resultB);
	}

}
/**
3 5
1 2 4
2 3 4 5 6
*/