package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_Dijkstra {
	
	static int N, M, S, E;
	static final int INF = Integer.MAX_VALUE;
	static int[] Distance, Visit;
	static ArrayList<ArrayList<Edge>> adjList;
	
	public static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int f, int t, int w){
			from = f;
			to = t;
			weight = w;
		}
		
		public int compareTo(Edge arg){
			return this.weight - arg.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());			//정점 초기화
		Distance = new int[N+1];
		Visit = new int[N+1];
		
		for(int i=1; i<=N; i++)						//최단거리 배열 초기화
			Distance[i] = INF;
		
		adjList = new ArrayList<ArrayList<Edge>>();		//인접리스트 초기화
		for(int i=1; i<=N+1; i++)
			adjList.add(new ArrayList<Edge>());
		
		M = Integer.parseInt(br.readLine());			//간선 가중치 인접리스트 입력
		for(int i=1; i<=M; i++){
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList.get(f).add(new Edge(f,t,w));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(Distance[E]);
	}

	public static void dijkstra(){
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		//Visit[S] = 1;
		Distance[S] = 0;
		
		pq.add(new Edge(S, S, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(Visit[now.to] != 0) continue;
			Visit[now.to] = 1;
			
			for(Edge next : adjList.get(now.to)) {
				if(Distance[next.to] > Distance[next.from] + next.weight) {
					Distance[next.to] = Distance[next.from] + next.weight;
					pq.add(new Edge(next.from, next.to, Distance[next.to]));
				}
			}
		}
	}
}


/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

4
*/