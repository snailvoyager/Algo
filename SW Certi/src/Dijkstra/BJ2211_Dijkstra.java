package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2211_Dijkstra {
	static int N, M;
	static int[] D, V, P;
	static final int INF = 1000;
	
	static class Edge implements Comparable<Edge>{
		int to, cost;
		
		Edge(int _to, int _cost){
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
		M = Integer.parseInt(st.nextToken());
		D = new int[N+1];
		V = new int[N+1];
		P = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			D[i] = INF;
		}
		
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Edge(to, cost));
			adjList.get(to).add(new Edge(from, cost));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		D[1] = 0;
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(V[e.to] != 0 )	continue;
			V[e.to] = 1;
			
			for(Edge next : adjList.get(e.to)) {
				if(D[next.to] > D[e.to] + next.cost ) {
					D[next.to] = D[e.to] + next.cost;
					pq.add(new Edge(next.to, D[next.to]));
					P[next.to] = e.to;
				}
			}
		}
		
//		bw.write(Arrays.toString(D)+"\n");
//		bw.write(Arrays.toString(P)+"\n");
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(P[i] != 0)
				cnt++;
		}
		bw.write(cnt+"\n");
		
		for(int i=1; i<=N; i++) {
			if(P[i] != 0) {
				bw.write(i + " " + P[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
/*
4 5
1 2 1
1 4 4
1 3 2
4 2 2
4 3 3

3
1 2
3 1
4 2
*/