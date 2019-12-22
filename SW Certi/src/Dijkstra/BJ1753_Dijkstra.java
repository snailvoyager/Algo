package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_Dijkstra {
	
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> L;
	static int[] D, Visit;
	static final int INF = Integer.MAX_VALUE;
	
	public static class Edge implements Comparable<Edge>{
		int to, weight;
		
		public Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge arg){
			return this.weight - arg.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = new ArrayList<ArrayList<Edge>>();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		D = new int[V+1];
		Visit = new int[V+1];
		
		for(int i=1; i<=V+1; i++){
			L.add(new ArrayList<Edge>());
		}
		
		for(int i=1; i<=V; i++)
			D[i] = INF;
		
		for(int i=1; i<=E; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			L.get(from).add(new Edge(to, weight));
		}
		
		dijkstra();
		
		for(int i=1; i<=V; i++){
			if(Visit[i] == 0)
				bw.write("INF\n");
			else
				bw.write(D[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(){
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		D[K] = 0; 					//시작노드 방문
		pq.add(new Edge(K,0));
			
		while(!pq.isEmpty()) {
			Edge e = pq.poll();		//우선순위큐에서 꺼내기 : 시작점부터 최단거리가 되는 간선
			if(Visit[e.to] != 0)
				continue;
			Visit[e.to] = 1;		//방문 체크
			
			for(Edge next : L.get(e.to)) {
				if(D[next.to] > D[e.to] + next.weight ) {	//간선완화 : 다음 정점 거리가 짧으면 변경 
					D[next.to] = D[e.to] + next.weight;
					pq.add(new Edge(next.to, D[next.to]));	//다음정점과 그거리를 큐에 저장
				}
					
			}
		}
	}
}
/**
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF
*/