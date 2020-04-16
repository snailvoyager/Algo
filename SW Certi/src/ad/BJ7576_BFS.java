package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ7576_BFS {
	static int N, M, Result, Untomato, Ontomato;
	static int[][] Board;
	static Deque<Node> Q = new ArrayDeque<Node>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static class Node{
		int x, y, cnt;
		
		public Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		Board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int k = Integer.parseInt(st.nextToken());
				Board[i][j] = k;
				if(k == 1) {
					Q.offer(new Node(i, j, 0));
				}
				if(k == 0) {	//익지 않은 토마토 갯수
					Untomato++;
				}
			}
		}
		
		while(!Q.isEmpty()) {
			Node n = Q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = n.x + dx[i];
				int yy = n.y + dy[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<M && Board[xx][yy] == 0) {	//익지 않은 토마토를 만나면
					Ontomato++;			//익은 토마토 갯수
					Board[xx][yy] = n.cnt+1;		//방문 체크
					Q.offer(new Node(xx, yy, n.cnt+1));
					if(Result < n.cnt+1)
						Result = n.cnt + 1;
				}
			}
		}
		
		if(Ontomato == Untomato)
			System.out.println(Result);
		else
			System.out.println(-1);
	}

}
