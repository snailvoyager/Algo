package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1697_BFS {
	static int N, K, Answer;
	static boolean[] Visit = new boolean[100001];
	
	static class Node{
		int n, cnt;
		
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Deque<Node> Q = new ArrayDeque<>();
		Q.add(new Node(N, 0));
		
		while(!Q.isEmpty()) {
			Node node = Q.poll();
			if(node.n == K) {
				System.out.println(node.cnt);
				return;
			}
			
			if(node.n * 2 <= 100000 && !Visit[node.n * 2]) {
				Q.add(new Node(node.n*2, node.cnt+1));
				Visit[node.n*2] = true;
			}
			if(node.n + 1 <= 100000 && !Visit[node.n+1]) {
				Q.add(new Node(node.n+1, node.cnt+1));
				Visit[node.n+1] = true;
			}
			if(node.n -1 >= 0 && !Visit[node.n-1]) {
				Q.add(new Node(node.n-1, node.cnt+1));
				Visit[node.n-1] = true;
			}
			
		}
	}

}
