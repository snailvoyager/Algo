package BellmanFord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1738_BellmanFord {
	static int N, M;
	static int[] D, P, Next;
	static final int INF = Integer.MIN_VALUE;
	
	static class Edge{
		int from, to, cost;
		
		Edge(int _from, int _to, int _cost){
			this.from = _from;
			this.to = _to;
			this.cost = _cost;
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
		P = new int[N+1];
		Next = new int[N+1];
		
		ArrayList<Edge> list = new ArrayList<Edge>();
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		for(int i=1; i<=N; i++) {
			D[i] = INF;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(from,to,cost));
			adjList.get(from).add(new Edge(from, to, cost));
		}
		
		boolean success = false;
		//BFS
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(1);
		while(!Q.isEmpty()) {
			int curr = Q.poll();
			
			if(Next[curr] == 1) continue;
			Next[curr] = 1;
			
			for(Edge e : adjList.get(curr)) {
				if(e.to == N) {
					success = true;
					break;
				}
				Q.offer(e.to);
			}
		}
		
		D[1] = 0;
		P[1] = 1;
		boolean cycleFlag = false;
		
		for(int i=1; i<=N; i++) {
			for(Edge e : list) {
				if(D[e.from] != INF && D[e.to] < D[e.from] + e.cost) {
					D[e.to] = D[e.from] + e.cost;
					P[e.to] = e.from;
					if(i == N) {
						cycleFlag = true;
					}
				}
					
			}
		}
		
//		bw.write(Arrays.toString(Next));
		if(success) {
			
			if(cycleFlag || D[N] == INF)
				bw.write("-1");
			else {
				Stack<Integer> stack = new Stack<Integer>();
				int i = N;
				stack.push(i);
				while(i > 1) {
	//				bw.write(P[i] + " ");
					stack.push(P[i]);
					i = P[i];
				}
				while(!stack.isEmpty()) {
					bw.write(stack.pop() + " ");
				}
				
//				bw.write(Arrays.toString(P)+"\n");
//				bw.write(Arrays.toString(D));
			}
		} else
			bw.write("-1");
		bw.flush();
		bw.close();
	}

}
/*
5 7
1 2 3
1 3 4
3 1 -7
2 3 2
3 4 1
4 2 -5
4 5 1

1 2 3 4 5
 */
