package MST;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ2887_Kruskal {
	
	static int[] p;
	static int[] r;
	static int N;
	
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
		
		for(int i=0; i<=N; i++){
			p[i] = i;
			r[i] = 0;
		}
	}
	
	public static int find_set(int x){
		if(x != p[x]){
			p[x] = find_set(p[x]);
		}
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
		
		int cnt = N-1;
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
		int[][] A = new int[N+1][3];
		
		for(int i=1; i<=N; i++){
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
			A[i][2] = sc.nextInt();
		}
		
		int from, to, weight;
		
		for(int i=1; i<N; i++){
			for(int j=i+1; j<N; j++){
				from = i;
				to = j;
				weight = Math.min(Math.min(Math.abs(A[i][0] - A[j][0]), Math.abs(A[i][1] - A[j][1])), Math.abs(A[i][2] - A[j][2]));
				
				edges.add(new Edge(from, to, weight));
			}
		}
		make_set();
		System.out.println(kruskal());
	}

}
