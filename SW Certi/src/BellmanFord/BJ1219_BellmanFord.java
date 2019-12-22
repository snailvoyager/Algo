package BellmanFord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1219_BellmanFord {
	static int N, M, S, F;
	static int[] Visit, Income;
	static long[] D;
	static final long INF = Long.MIN_VALUE;
	
	static class Edge{
		int f, t, c;
		
		Edge(int _f, int _t, int _c){
			this.f = _f;
			this.t = _t;
			this.c = _c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new long[N];
		Visit = new int[N];
		Income = new int[N];
		
		LinkedList<Edge> list = new LinkedList<Edge>();
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<N; i++) {
			adjList.add(new ArrayList<Edge>());
			D[i] = INF;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(f, t, -c));
			adjList.get(f).add(new Edge(f, t, c));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int income = Integer.parseInt(st.nextToken());
			Income[i] = income;
		}
		
		boolean success = false;
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.offer(S);
		
		while(!dq.isEmpty()) {				//BFS 도착점 확인
			int hear = dq.poll();
			if(Visit[hear] == 1) continue;
			Visit[hear] = 1;
			
			for(Edge e : adjList.get(hear)) {
				int next = e.t;
				if(next == F) {
					success = true;
					break;
				}
				dq.offer(next);
			}
			if(success) break;
		}
		
		//if(success) {					//도착점까지 갈수 있으면
			boolean cycle = false;
			
			D[S] = Income[S];			//시작점 초기화
			for(int i=0; i<N+100; i++) {
				for(Edge e : list) {
					if(D[e.f] ==INF) continue;
					else if(D[e.f] == Long.MAX_VALUE)
						D[e.t] = Long.MAX_VALUE; 
					else if(D[e.f] !=INF && D[e.t] < D[e.f] + e.c + Income[e.t]) {	//방문 정점의 수익까지 최대합
						D[e.t] = D[e.f] + e.c + Income[e.t];
						
						if(i==N-1) {	//N번째에서도 변경되면 사이클 존재
							cycle = true;
							D[e.t] = Long.MAX_VALUE; 
						}
					}
				}
			}
			
			if(D[F] == INF)
				bw.write("gg");
			else if(D[F] == Long.MAX_VALUE)
				bw.write("Gee");
			else {
				bw.write(D[F] + "");
			}
			
		//} else {
//			bw.write("gg");
		//}
		
		
		bw.flush();
		bw.close();
	}

}
