package Professional;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Kruskal {
	
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
		
		public String toString(){
			return "(" + u + "-" + v + ", " + w + ")";
		}
	}
	static LinkedList<Edge> edges = new LinkedList<Edge>();
	static LinkedList<Edge> tree = new LinkedList<Edge>();
	
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
		
		if(r[a] > r[b])
			p[b] = a;
		else{
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	
	public static int kruskal(){
		int cost = 0;
		Collections.sort(edges);
		make_set();
		
		int cnt = N - 1;
		while(cnt > 0){
			Edge e = edges.removeFirst();
			
			int a = find_set(e.u);
			int b = find_set(e.v);
			if(a == b) continue;
			
			union_set(a, b);
			cost += e.w;
			
			tree.add(e);
			cnt--;
		}
		
		return cost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int from, to, weight;
		for(int i=0; i<M; i++){
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();
			edges.add(new Edge(from, to, weight));
		}
		
		System.out.println("cost : " + kruskal());
		for(Edge e : tree)
			System.out.println(e);
	}

}
/* �Է�>
-------------
9 14
1 2 4
1 7 8
2 3 8
2 7 11
3 4 7
3 5 2
3 9 4 
4 6 9 
4 9 14
5 7 2
5 8 6
6 9 10
7 8 1
8 9 2

35
-------------
*/