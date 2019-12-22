package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2178 {
	
	static int N, M;
	static ArrayList<List<Integer>> adjList = new ArrayList<List<Integer>>();
	static int[][] Visit;
	static int[][] Path;
	static Deque<Edge> deque = new ArrayDeque<Edge>();
	
	public static class Edge {
		int x, y;
		
		Edge(int _x, int _y){
			x = _x;
			y = _y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Visit = new int[N][M];
		Path = new int[N][M];
		
		/*for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				Path[i][j] = Integer.parseInt(st.nextToken());
			}
		}*/
		
		//인접리스트 입력
		for(int i=0; i<N; i++){
			adjList.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<M; j++){
				int n = Integer.parseInt(s.substring(j, j+1));
				adjList.get(i).add(n);
			}
		}
		
		/*for(int i=0; i<N; i++){
			for(int j:adjList.get(i))
				System.out.print(j + " ");
			System.out.println();
		}*/
		//Start
		Visit[0][0] = 1;
		deque.add(new Edge(0,0));
		//BFS
		while(!deque.isEmpty()){
			Edge e = deque.poll();
			int X = e.x;
			int Y = e.y;
//			System.out.println(X + " " + Y);
			
			if(X+1<N && adjList.get(X).get(Y) == 1 && Visit[X+1][Y] == 0){
				Visit[X+1][Y] = Visit[X][Y] + 1;
				deque.add(new Edge(X+1, Y));
			}
			if(Y+1<M && adjList.get(X).get(Y) == 1 && Visit[X][Y+1] == 0){
				Visit[X][Y+1] = Visit[X][Y] + 1;
				deque.add(new Edge(X, Y+1));
			}
			if(X-1>-1 && adjList.get(X).get(Y) == 1 && Visit[X-1][Y] == 0){
				Visit[X-1][Y] = Visit[X][Y] + 1;
				deque.add(new Edge(X-1, Y));
			}
			if(Y-1>-1 && adjList.get(X).get(Y) == 1 && Visit[X][Y-1] == 0){
				Visit[X][Y-1] = Visit[X][Y] + 1;
				deque.add(new Edge(X, Y-1));
			}
		}
		
		System.out.println(Visit[N-1][M-1]);
		
	}

}
