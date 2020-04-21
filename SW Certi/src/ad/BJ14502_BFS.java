package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14502_BFS {
	static int[][] Map;
	static int N, M, Answer;
	static List<Node> Virus = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(st.nextToken());
				Map[i][j] = n;
				if(n == 2)
					Virus.add(new Node(i, j));
			}
		}
		combi(0, 0);
		System.out.println(Answer);
	}
	
	public static void combi(int start, int depth) {		//2차원 배열 조합
		if(depth == 3) {		//벽 3개를 세웠으면 바이러스 전파
			bfs();
			searchSafe();
			return;
		}
		for(int i=start; i<N*M; i++) {
			int x = i / M;		//X 좌표
			int y = i % M;		//Y 좌표
			
			if(Map[x][y] == 0) {
				Map[x][y] = 1;			//빈칸에 벽을 세운다
				combi(i+1, depth+1);	//다음 벽 세우기
				Map[x][y] = 0;			//빈칸 원복
			}
		}
	}
	
	public static void searchSafe() {		//전체 탐색
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Map[i][j] == 0) {		//안전영역 체크
					cnt++;
				}
				if(Map[i][j] == -1) {		//바이러스가 전파됐던 곳 원복
					Map[i][j] = 0;
				}
			}
		}
		if(cnt > Answer)
			Answer = cnt;
	}
	
	public static void bfs() {
		Deque<Node> Q = new ArrayDeque<>();
		for(int i=0; i<Virus.size(); i++) {		//바이러스 꺼내서 큐에 담기
			Node v = Virus.get(i);
			Q.offer(v);
		}
		
		while(!Q.isEmpty()) {		//BFS
			Node node = Q.poll();
			
			for(int d=0; d<4; d++) {
				int xx = node.x + dx[d];
				int yy = node.y + dy[d];
				
				if(xx>=0 && xx<N && yy>=0 && yy<M && Map[xx][yy] == 0) {
					Map[xx][yy] = -1;
					Q.offer(new Node(xx, yy));
				}
			}
		}
	}
}
