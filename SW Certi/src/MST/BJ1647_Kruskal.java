package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1647_Kruskal {
	
	static int N, M, Answer, Cnt;
	static int[] P;
	static LinkedList<Edge> Arr = new LinkedList<Edge>();
	
	static class Edge implements Comparable<Edge>{
		int f, t, c;
		
		public Edge(int _f, int _t, int _c) {
			this.f = _f;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		P = new int[N+1];
		for(int i=0; i<=N; i++) {
			P[i] = i;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			Arr.add(new Edge(from, to, cost));
		}
		kruskal() ;
		System.out.println(Answer);
	}
	
	static int find_set(int n) {
		if(n != P[n])
			P[n] = find_set(P[n]);
		return P[n];
	}
	
	static void union_set(int a, int b) {
		int rootA = find_set(a);
		int rootB = find_set(b);
		
		if(rootA == rootB)	return;
		
		P[rootB] = rootA;
	}
	
	static void kruskal() {
		Collections.sort(Arr);	//리스트 정렬
		
		while(!Arr.isEmpty()) {
			Edge e = Arr.poll();
			
			int rootA = find_set(e.f);
			int rootB = find_set(e.t);
			if(rootA == rootB)	continue;
			
			P[rootB] = rootA;
			Answer += e.c;
			Cnt++;	//MST 간선 수 : N-1
			if(Cnt == N-2) break;	//마을 하나는 분할하기 위해 : N-2
		}
	}

}
/**
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

8
 */
