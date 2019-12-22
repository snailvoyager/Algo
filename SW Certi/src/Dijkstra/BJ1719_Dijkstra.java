package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1719_Dijkstra {
	static int N, M;
	static int[] D, V, P;
	static int[][] Result;
	static final int INF = 10000;
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();

	static class Edge implements Comparable<Edge>{
		int t, c;
		
		Edge(int _t, int _c){
			this.t = _t;
			this.c = _c;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.c - o.c;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Result = new int[N+1][N+1];

		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList.get(f).add(new Edge(t, c));
			adjList.get(t).add(new Edge(f, c));
		}
		
		for(int i=1; i<=N; i++) {	//모든 정점 다익스트라로 돌리기 
			V = new int[N+1];
			P = new int[N+1];	//부모 저장
			D = new int[N+1];
			for(int j=1; j<=N; j++) {
				D[j] = INF;
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			
			D[i] = 0;	//시작점
			pq.add(new Edge(i, 0));
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				
				if(V[e.t] != 0) continue;
				V[e.t] = 1;
				
				for(Edge next : adjList.get(e.t)) {
					if(D[next.t] > D[e.t] + next.c) {
						D[next.t] = D[e.t] + next.c;
						P[next.t] = e.t; 
						pq.add(new Edge(next.t, D[next.t]));
					}
				}
			}
//			bw.write(Arrays.toString(P)+"\n");
			for(int j=1; j<=N; j++) {
				int result = search(i, j);
				if(result == 0)
					bw.write("- ");
				else
					bw.write(result + " ");
			}
			bw.write("\n");
		}
		
		
		bw.flush();
		bw.close();
	}
	
	static public int search(int i, int p) {
		if(P[p] == 0)
			return 0;
		else if(P[p] == i)
			return p;
		else
			return search(i, P[p]);
	}

}
/*
6 10
1 2 2
1 3 1
2 4 5
2 5 3
2 6 7
3 4 4
3 5 6
3 6 7
4 6 4
5 6 2

- 2 3 3 2 2
1 - 1 4 5 5
1 1 - 4 5 6
3 2 3 - 6 6
2 2 3 6 - 6
5 5 3 4 5 -

*/
