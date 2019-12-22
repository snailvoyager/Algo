package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11279_PriorityQ {
	
	static int N;
	
	public static class Node implements Comparable<Node>{
		int n;
		
		public Node(int _n) {
			this.n = _n;
		}
		
		public int getN() {
			return this.n;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.n <= o.n ? 1 : -1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			
			if(x == 0) {
				if(pq.isEmpty())
					System.out.println(0);
				else {
					//System.out.println("poll");
					System.out.println(pq.poll().getN());
				}
			} else {
				//System.out.println("input");
				pq.add(new Node(x));
			}
		}
	}

}
/*
13
0
1
2
0
0
3
2
1
0
0
0
0
0
*/