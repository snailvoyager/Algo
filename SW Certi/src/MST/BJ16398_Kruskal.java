package MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ16398_Kruskal {
	static int N;
	static long Result;
	static int[][] C;
	static int[] P, R;
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		Edge(int _from, int _to, int _cost){
			this.from = _from;
			this.to = _to;
			this.cost = _cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = new int[N+1][N+1];
		P = new int[N+1];
		R = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			P[i] = i;
		}
		
		LinkedList<Edge> arrList = new LinkedList<Edge>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				C[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N-1; i++) {
			for(int j=i+1; j<=N; j++) {
				arrList.add(new Edge(i, j, C[i][j]));
			}
		}
		
//		for(int i=0; i<arrList.size(); i++)
//			bw.write(arrList.get(i).from + " " + arrList.get(i).to + " " + arrList.get(i).cost +"\n");
		
		Collections.sort(arrList);
		while(!arrList.isEmpty()) {
			Edge e = arrList.poll();
			
			int rootA = findSet(e.from);
			int rootB = findSet(e.to);
			
			if(rootA != rootB) {
				unionSet(rootA, rootB);
				Result += e.cost;
			}
		}
		
		bw.write(Result+"");
		bw.flush();
		bw.close();
	}
	
	public static void unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA != rootB) {
			if(R[rootA] > R[rootB]) {
				P[rootB] = rootA;
			} else {
				P[rootA] = rootB;
				if(R[rootA] == R[rootB])
					R[rootB]++;
			}
		}
		
	}
	
	public static int findSet(int n) {
		if(n != P[n])
			P[n] = findSet(P[n]);
		return P[n];
	}

}
