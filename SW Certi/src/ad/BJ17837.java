package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ17837 {
	static int N, K;
	static int[][] Map;
	static Node[] Horse;
	static LinkedList<Integer>[][] listMap;
	static int[] dx = {0, 0, 0, -1, 1};		//우, 좌, 상, 하
	static int[] dy = {0, 1, -1, 0, 0};
	
	static class Node{
		int x, y, d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Map = new int[N+1][N+1];
		listMap = new LinkedList[N+1][N+1];
		Horse = new Node[K];
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				listMap[i][j] = new LinkedList<Integer>();
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Horse[i] = new Node(x, y, d);
			listMap[x][y].add(i);
		}
		
		for(int Answer=1; Answer<1000; Answer++) {
			for(int i=0; i<K; i++) {		//한턴에 K번 말 이동
				int x = Horse[i].x;
				int y = Horse[i].y;
				int d = Horse[i].d;
				
				int idx = 0;
				for(int j=0; j<listMap[x][y].size(); j++) {		//말이 저장된 리스트 인덱스 탐색
					if(i == listMap[x][y].get(j)) {
						idx = j;
						break;
					}
				}
				
				int nextX = x + dx[d];		//이동할 좌표
				int nextY = y + dy[d];
				
				if(nextX>0 && nextX<=N && nextY>0 && nextY<=N && Map[nextX][nextY] == 0) {	//흰색 칸일 때
					for(int j=idx; j<listMap[x][y].size(); j++) {	//말이 저장된 인덱스부터 마지막까지 말 함께 이동
						int n = listMap[x][y].get(j);
						listMap[nextX][nextY].add(n);
						Horse[n].x = nextX;
						Horse[n].y = nextY;
					}
					
					for(int j=listMap[x][y].size()-1; j>=idx; j--) {	//이동 후 삭제
						listMap[x][y].removeLast();
					}
					
					if(listMap[nextX][nextY].size()>=4)	{	// 4개가 쌓이면 중단
						System.out.println(Answer);
						System.exit(0);
					}
					
				} else if (nextX>0 && nextX<=N && nextY>0 && nextY<=N && Map[nextX][nextY] == 1) {	//빨간 칸일 때
					
				} else {	//파란칸이거나 체스판을 벗어날 때
					
				}
				
			}
		}
		
		System.out.println(-1);
		
	}

}
