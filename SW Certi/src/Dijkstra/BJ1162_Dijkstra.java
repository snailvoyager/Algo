package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1162_Dijkstra {
	static int N, M, K;
	static long[][] D;
	static int[][] V;
	static final long INF = Long.MAX_VALUE;
	
	static class Edge implements Comparable<Edge>{
		int t, k;
		long c;
		
		Edge(int _t, int _k, long _c){
			this.c = _c;
			this.t = _t;
			this.k = _k;
		}
		
		public int compareTo(Edge o) {
			return this.c < o.c ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		V = new int[N+1][K+1];
		D = new long[N+1][K+1];
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				D[i][j] = INF;
			}
		}
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList.get(f).add(new Edge(t, 0, c));
			adjList.get(t).add(new Edge(f, 0, c));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
//		for(int i=0; i<=K; i++)
//			D[1][i] = 0;
		pq.add(new Edge(1, 0, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(V[e.t][e.k]== 1) continue;
			V[e.t][e.k] = 1;
			
			for(Edge next : adjList.get(e.t)) {
				//포장도로를 사용하지 않을 때
				if(D[next.t][e.k] > D[e.t][e.k] + next.c ) {
					D[next.t][e.k] = D[e.t][e.k] + next.c;
					pq.add(new Edge(next.t, e.k, D[next.t][e.k]));
					//System.out.println(next.t + " " + e.k + " " + D[next.t][e.k]);
				}
				
				//포장도로를 사용할 때
				if(e.k + 1 <=K && D[next.t][e.k+1] > D[e.t][e.k]) {
					D[next.t][e.k+1] = D[e.t][e.k]; 
					pq.add(new Edge(next.t, e.k+1, D[next.t][e.k+1]));
					//System.out.println(next.t + " "+ (e.k+1) + " " + D[next.t][e.k+1]);
				}
			}
		}
		long Answer = INF;
		for(int i=0; i<=K; i++) {
			Answer = Math.min(Answer, D[N][i]);
		}
		bw.write(Answer+"");
		bw.flush();
		bw.close();
	}

}
/*
4 4 1
1 2 10
2 4 10
1 3 1
3 4 100

1
*/