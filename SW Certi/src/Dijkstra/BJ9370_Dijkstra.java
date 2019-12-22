package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ9370_Dijkstra {
	static int[] D, V, X;
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge>{
		int t, c;
		
		Edge(int _t, int _c){
			this.t = _t;
			this.c = _c;
		}
		
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			D = new int[N+1];
			V = new int[N+1];
			X = new int[T+1];
			
			for(int i=1; i<=N; i++) {
				D[i] = INF;
			}
			
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
			for(int i=0; i<=N; i++)
				adjList.add(new ArrayList<Edge>());
			
			for(int i=1; i<=M; i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if((f==G && t==H) || (f==H && t==G)) {
					c = (c * 2) -1;		//G, H 간선 가중치를 홀수로 만들기 위해 -1
				} else {
					c = c * 2;			//간선 가중치를 짝수로 만들기 위해 *2
				}
				adjList.get(f).add(new Edge(t, c));	
				adjList.get(t).add(new Edge(f, c));
			}
			
			for(int i=1; i<=T; i++) {
				X[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(X);		//오름차순으로 출력하기 위해 미리 정렬
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			D[S] = 0;
			pq.add(new Edge(S, D[S]));
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(V[e.t] == 1)	continue;
				V[e.t] = 1; 
				
				for(Edge next : adjList.get(e.t)) {
					if(D[next.t] > D[e.t] + next.c) {
						D[next.t] = D[e.t] + next.c;
						pq.add(new Edge(next.t, D[next.t]));
					}
				}
			}
			
			//bw.write(Arrays.toString(D)+"\n");
			for(int i=1; i<=T; i++) {
				int n = X[i];
				if(D[n] != INF && D[n] % 2 > 0)		//목적지의 최단경로가 홀수면 홀수였던 GH 간선을 지났음 
					bw.write(n + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
