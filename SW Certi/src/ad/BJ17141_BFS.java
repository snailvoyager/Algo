package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17141_BFS {
	static int N, M;
	static int Answer = Integer.MAX_VALUE;
	static int V;	//바이러스 수
	static int G;	//빈칸 수
	static int[][] Map;
	static List<Node> Virus = new ArrayList<>();
	
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
					Virus.add(new Node(i, j));
					Map[i][j] = 0;
				}else if(n == 1){	//벽
					Map[i][j] = -1;
				}else {				//빈칸
					Map[i][j] = n;
					G++;
				}
			}
		}
		combi(V, M, 0);
		
		System.out.println(Answer);
	}
	
	public static void combi(int n, int r, int start) {
		
	}
	
	public static void bfs() {
		
	}
	
	public static void resetMap() {
		int cnt = 0;
		int time = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(Map[i][j] != -1) {
					if(time < Map[i][j])
						time = Map[i][j];		//가장 큰 시간
					Map[i][j] = 0;
					cnt++;
				}
			}
		}
		if(Answer > time)		//가장 적은 시간
			Answer = time;
	}

}
