package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1991_Tree {
	static int N;
	static ArrayList<ArrayList<Integer>> tree;
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUWVXYZ.";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tree = new ArrayList<ArrayList<Integer>>();
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<26; i++){
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			tree.get(alphabet.indexOf(parent)).add(alphabet.indexOf(left));
			tree.get(alphabet.indexOf(parent)).add(alphabet.indexOf(right));
		}
		
		/*for(int i =0; i<N; i++){
			System.out.println(alphabet.charAt(i) + " " + alphabet.charAt(tree.get(i).get(0)) + " " + alphabet.charAt(tree.get(i).get(1)));
		}*/
		
		preSearch(0);
		System.out.println();
		midSearch(0);
		System.out.println();
		postSearch(0);
	}
	
	public static void preSearch(int node){
		//노드 진입할 때 출력
		System.out.print(alphabet.charAt(node));
		
		if(tree.get(node).get(0) != 26){
			preSearch(tree.get(node).get(0));
		}
		if(tree.get(node).get(1) != 26){
			preSearch(tree.get(node).get(1));
		}
	}
	
	public static void midSearch(int node){
		//왼쪽 자식을 먼저 출력
		if(tree.get(node).get(0) != 26){
			midSearch(tree.get(node).get(0));
		}
		
		System.out.print(alphabet.charAt(node));
		
		if(tree.get(node).get(1) != 26){
			midSearch(tree.get(node).get(1));
		}
		
	}
	
	public static void postSearch(int node){
		//오른쪽 자식을 먼저 방문
		if(tree.get(node).get(0) != 26){
			postSearch(tree.get(node).get(0));
		}
		
		if(tree.get(node).get(1) != 26){
			postSearch(tree.get(node).get(1));
		}
		
		System.out.print(alphabet.charAt(node));
		return;
	}

}
/**
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
*/