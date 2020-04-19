package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1012_DFS {
	static int M, N, K, Answer;
	static int[][] Map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			Answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			Map = new int[N][M];
			Deque<Node> Q = new ArrayDeque<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				Map[x][y] = 1;
				Q.offer(new Node(x, y));		//위치저장
			}
			
			int flag = 1;
			while(!Q.isEmpty()) {
				Node node = Q.poll();
				if(Map[node.x][node.y] == 1) {		//새로운 블럭을 만나면
					flag++;
					Answer++;
					//System.out.println(node.x + ", " + node.y + " " + flag);
					dfs(node.x, node.y, flag);
				}
			}
			
			System.out.println(Answer);
		}
	}
	
	public static void dfs(int x, int y, int flag) {
		Map[x][y] = flag;		//방문체크
		for(int i=0; i<4; i++) {		//상하좌우 체크
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx>=0 && xx<N && yy>=0 && yy<M && Map[xx][yy] == 1) {
				//System.out.println("DFS : " + xx + ", " + yy + " " + flag);
				dfs(xx, yy, flag);
			}
		}
		//return;
	}

}
