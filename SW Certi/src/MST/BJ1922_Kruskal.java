package MST;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1922_Kruskal {

	static int[] p;
	static int[] r;
	static int N, M;
	
	public static class Edge implements Comparable<Edge>{
		int u, v, w;
		
		Edge(int _u, int _v, int _w){
			u = _u; v = _v; w = _w;
		}
		
		public int compareTo(Edge arg){
			return w - arg.w;
		}
	}
	static LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public static void make_set(){
		p = new int[N+1];
		r = new int[N+1];
		
		for(int i=1; i<=N; i++){
			p[i] = i;
			r[i] = 0;
		}
	}
	
	public static int find_set(int x){
		if(x != p[x])
			p[x] = find_set(p[x]);
		
		return p[x];
	}
	
	public static void union_set(int x, int y){
		int a = find_set(x);
		int b = find_set(y);
		if(a == b) return;
		
		if(r[a] > r[b]) p[b] = a;
		else{
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	
	public static int kruskal(){
		int cost = 0;
		Collections.sort(edges);
		
		int cnt = N - 1;
		while(cnt > 0){
			Edge e = edges.removeFirst();
			int a = find_set(e.u);
			int b = find_set(e.v);
			if(a == b) continue;
			
			union_set(a, b);
			cost += e.w;
			
			--cnt;
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		make_set();
		
		int from, to, weight;
		for(int i=0; i<M; i++){
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();
			edges.add(new Edge(from, to, weight));
		}
		
		System.out.println(kruskal());
	}

}

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

23
 */
