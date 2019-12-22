package MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2887_Kruskal2 {
	static int N, Answer;
	static int[][] M;
	static int[] P, R;
	
	static class Edge implements Comparable<Edge>{
		int f, t, c;
		
		Edge(int _f, int _t, int _c){
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
	
	static class Node{
		int x, y, z, idx;
		
		Node(int _x, int _y, int _z, int _idx){
			this.x = _x;
			this.y = _y;
			this.z = _z;
			this.idx = _idx;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = new int[N+1][3];
		P = new int[N+1];
		R = new int[N+1];
		for(int i=1; i<=N; i++) {
			P[i] = i;
			R[i] = 0;
		}
		
		Node[] node = new Node[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			node[i] = new Node(x, y, z, i);
		}
		
		PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
		
		// XÁÂÇ¥·Î Á¤·Ä
		Comparator<Node> cp = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		};
		
		Arrays.sort(node, cp);
		
		for(int i=1; i<N; i++) {
			PQ.add(new Edge(node[i-1].idx, node[i].idx, Math.abs(node[i-1].x - node[i].x)));
		}
		
		// YÁÂÇ¥·Î Á¤·Ä
		cp = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		};
		
		Arrays.sort(node, cp);
		for(int i=1; i<N; i++) {
			PQ.add(new Edge(node[i-1].idx, node[i].idx, Math.abs(node[i-1].y - node[i].y)));
		}
		
		// ZÁÂÇ¥·Î Á¤·Ä
		cp = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.z - o2.z;
			}
		};
		
		Arrays.sort(node, cp);
		for(int i=1; i<N; i++) {
			PQ.add(new Edge(node[i-1].idx, node[i].idx, Math.abs(node[i-1].z - node[i].z)));
		}
		
		
		while(!PQ.isEmpty()) {
			Edge e = PQ.poll();
			
			int rootA = findSet(e.f);
			int rootB = findSet(e.t);
			
			if(rootA == rootB) continue;
			
			unionSet(rootA, rootB);
			Answer += e.c;
			
//			bw.write(e.f + " " + e.t + " " + e.c + "\n");
		}
		bw.write(Answer+"");
		bw.flush();
		bw.close();
	}
	
	static void unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA != rootB) {
			if(R[rootA] > R[rootB])
				P[rootB] = rootA;
			else {
				P[rootA] = rootB;
				if(R[rootA] == R[rootB])
					R[rootB]++;
			}
				
		}
	}
	
	static int findSet(int n) {
		if(n != P[n])
			P[n] = findSet(P[n]);
		return P[n];
	}

}
