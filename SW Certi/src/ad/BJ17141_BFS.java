package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17141_BFS {
	static int N, M;
	static int Answer = Integer.MAX_VALUE;
	static int V;	//바이러스 자리수
	static int G;	//빈칸 수
	static int Cnt; //바이러스가 퍼진 수
	static int[][] Map;
	static List<Node> Virus = new ArrayList<>();
	static boolean[] Visit;
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
		
		Map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 2) {		//바이러스
					V++;
					Virus.add(new Node(i, j));		//바이러스 자리 리스트 저장
					Map[i][j] = 0;			//빈칸으로 생각
					G++;
				}else if(n == 1){	//벽
					Map[i][j] = -1;
				}else {				//빈칸
					Map[i][j] = n;
					G++;
				}
			}
		}
		
		Visit = new boolean[V];
		combi(V, M, 0);
		
		if(Answer != Integer.MAX_VALUE)
			System.out.println(Answer);
		else
			System.out.println(-1);
	}
	
	public static void combi(int n, int r, int start) {
		if(r == 0) {
			Node[] v = new Node[M];			//조합으로 뽑은 M개 바이러스를 저장
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(Visit[i]) {
					v[cnt] = Virus.get(i);
					cnt++;
				}
			}
			bfs(v);							//M개 바이러스를 bfs
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(Map[i]));
//			}
//			System.out.println();
			resetMap();						//Map 원복, 시간 체크
			return;
		}
		for(int i=start; i<n; i++) {
			Visit[i] = true;
			combi(n, r-1, i+1);
			Visit[i] = false;
		}
	}
	
	public static void bfs(Node[] v) {
		Deque<Node> Q = new ArrayDeque<>();
		Cnt = 0;
		boolean[][] Visit2 = new boolean[N][N];
		
		for(int i=0; i<v.length; i++) {		//M개 바이러스 bfs 시작
			Q.offer(v[i]);
			Visit2[v[i].x][v[i].y] = true; 
			Cnt++;
		}
		
		while(!Q.isEmpty()) {
			Node node = Q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N && Map[xx][yy] == 0 && !Visit2[xx][yy]) {
					Map[xx][yy] = Map[node.x][node.y] + 1;		//이전 위치에서 1초 증가
					Visit2[xx][yy] = true;
					Q.offer(new Node(xx, yy));
					Cnt++;						//바이러스가 퍼진 빈칸 수
				}
			}
		}
	}
	
	public static void resetMap() {
		int time = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(Map[i][j] != -1) {
					if(time < Map[i][j])
						time = Map[i][j];		//가장 큰 시간
					Map[i][j] = 0;
				}
			}
		}
		//System.out.println("G:"+ G + " cnt:"+Cnt + " time:"+time);
		if(Cnt == G) {				//총 빈칸 수와 동일하면 정답 갱신
			if(Answer > time) {		//가장 적은 시간
				Answer = time;	
			}
		}
	}

}
