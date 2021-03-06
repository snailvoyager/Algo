package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ2146_DFS {
	static int N;
	static int Answer = Integer.MAX_VALUE;
	static int[][] Map;
	static boolean[][] Visit;
	static Deque<Node> Q = new ArrayDeque<Node>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x, y, cnt, flag;
		
		public Node(int x, int y, int cnt, int flag) {
			this.x = x;
			this.y= y;
			this.cnt = cnt;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//육지 구분 탐색
		int flag = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(Map[i][j] == 1) {
					searchIsland(i, j, ++flag);
				}
			}
		}
		
//		for(int i=0; i<N; i++)
//			System.out.println(Arrays.toString(Map[i]));
		
		while(!Q.isEmpty()) {		//육지 간 거리 탐색
			Node n = Q.poll();
			bfs(n.x, n.y);
		}
		
		System.out.print(Answer);
	}
	
	public static void searchIsland(int x, int y, int flag) {
		Map[x][y] = flag;
		Q.offer(new Node(x, y, 0, flag));
		
		if(y+1 <N && Map[x][y+1] == 1) {	//우
			searchIsland(x, y+1, flag);
		}
		if(x+1 < N && Map[x+1][y] == 1) {	//하
			searchIsland(x+1, y, flag);
		}
		if(x-1 >=0 && Map[x-1][y] == 1) {	//상
			searchIsland(x-1, y, flag);
		}
		if(y-1 >=0 && Map[x][y-1] == 1) {	//좌
			searchIsland(x, y-1, flag);
		}
		return;
	}
	
	public static void searchBridge(int x, int y, int cnt, int flag) {
		if(cnt > Answer)	//지금까지 탐색했던 다리 길이보다 길면 백트래킹 
			return;
		
		if((y+1 < N && Map[x][y+1] != flag && Map[x][y+1] > 0) ||
				(x+1 < N && Map[x+1][y] != flag && Map[x+1][y] >0) ||
				(x-1 >= 0 && Map[x-1][y] != flag && Map[x-1][y] >0)) {	//다른 육지를 만나면 탐색 종료
			if(Answer > cnt)		//다리 길이가 짧으면 갱신
				Answer = cnt;	//System.out.println(x + ", " + y + " : " + cnt);
			return;
		}
		if(y+1 < N && Map[x][y+1] == 0) {		//우측
			Map[x][y+1] = -1;
			searchBridge(x, y+1, cnt+1, flag);
			Map[x][y+1] = 0;
		}
		if(x+1 < N && Map[x+1][y] == 0) {		//아래
			Map[x+1][y] = -1;
			searchBridge(x+1, y, cnt+1, flag);
			Map[x+1][y] = 0;
		}
		if(x-1 >= 0 && Map[x-1][y] == 0) {
			Map[x-1][y] = -1;
			searchBridge(x-1, y, cnt+1, flag);
			Map[x-1][y] = 0;
		}
		return;
	}
	
	public static void bfs(int x, int y) {
		Visit = new boolean[N][N];
		
		Deque<Node> Q2 = new ArrayDeque<>();	//육지간 거리 탐색
		Q2.offer(new Node(x, y, 0, Map[x][y]));
		
		while(!Q2.isEmpty()) {
			Node node = Q2.poll();
			
			if(node.cnt >= Answer)		//지금까지 찾은 다리보다 길면 스킵
				continue;
			
			for(int i=0; i<4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N) {
					if(Map[xx][yy] == 0 && !Visit[xx][yy]) {
						Visit[xx][yy] = true;		//방문체크
						Q2.offer(new Node(xx, yy, node.cnt+1, node.flag));
					}
					if(Map[xx][yy] > 1 && Map[xx][yy] != node.flag) {	//다른 섬을 만나면
						if(Answer > node.cnt)
							Answer = node.cnt;
					}
				}
			}
		}
	}

}
/**
3
1 0 0
0 0 0
0 0 1

10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

10
0 0 0 0 0 0 0 1 1 1
0 0 0 0 0 0 0 0 1 1
0 0 0 0 0 0 0 0 1 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

10
1 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 1
**/