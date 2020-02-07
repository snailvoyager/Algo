package ad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2667_BFS {
	static int N;
	static char[][] M;
	
	public static class Edge{
		int x, y;
		
		Edge(int _x, int _y){
			this.x = _x;
			this.y = _y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = new char[N][N];
		
		ArrayList<Integer> result = new ArrayList<Integer>();	//각 단지에 속하는 집의 수 저장 리스트
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M[i] = st.nextToken().toCharArray();
			//bw.write(Arrays.toString(M[i]) + "\n");
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(M[i][j] == '1') {
					result.add(bfs(i, j));
				}
			}
		}
		int size = result.size();
		bw.write(size + "\n");
		
		Collections.sort(result);
		for(int i : result)
			bw.write(i + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
	public static int bfs(int x, int y) {
		int n = 0;
		
		Queue<Edge> q = new LinkedList<Edge>();
		q.add(new Edge(x, y));
		
		while(!q.isEmpty()) {
			Edge next = q.poll();
			int i = next.x;
			int j = next.y;
			
			if(M[i][j] == '0')		//먼저 방문했는지 체크
				continue;
			
			M[i][j] = '0';
			n++;
			
			if(j+1 < N && M[i][j+1] == '1')
				q.add(new Edge(i, j+1));
			if(i+1 < N && M[i+1][j] == '1')
				q.add(new Edge(i+1, j));
			if(j-1 > -1 && M[i][j-1] == '1')
				q.add(new Edge(i, j-1));
			if(i-1 > -1 && M[i-1][j] == '1')
				q.add(new Edge(i-1, j));
		}
		return n;
	}

}
