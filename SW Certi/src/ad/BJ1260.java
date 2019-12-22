package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1260 {

	static int N, M, V1;
	static int[][] G;
	static int[] Visit;
	static Deque<Integer> deque = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V1 = Integer.parseInt(st.nextToken());
		G = new int[N+1][N+1];
		Visit = new int[N+1];
		
		for(int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			G[x][y] = 1;
			G[y][x] = 1;
		}
		
//		for(int i =1; i<=N; i++)
//			System.out.println(Arrays.toString(G[i]));
		
//		dfs1(V1);
//		System.out.println("DFS Finish");
		dfs2(V1);
		System.out.println();
		deque = new ArrayDeque<Integer>();
		Visit = new int[N+1];
		bfs(V1);
	}
	//인접행렬
	public static void dfs1(int v){
		System.out.print(v + " ");
		deque.push(v);
		Visit[v] = 1;
		int n = v;
		int cnt = 1;
		
		while(true){
			for(int i=1; i<=N; i++){
				if(G[n][i] == 1 && Visit[i] == 0){
					System.out.print(i + " ");
//					System.out.println("n: " + i + " cnt: " + cnt);
					Visit[i] = 1;
					deque.push(i);
					n = i;
					cnt++;
					break;
				}
			}
			if(cnt == N)	break;
			n = deque.pop();
		}
	}
	//Recursive
	public static void dfs2(int v){
		if(Visit[v] == 1){
			return;
		}
		Visit[v] = 1;
		System.out.print(v + " ");
		for(int i=v; i<=N; i++){
			if(G[v][i] == 1){
				dfs2(i);
			}
		}
	}
	
	public static void bfs(int v){
		deque.add(v);
		
		while(!deque.isEmpty()){
			int n = deque.poll();
			System.out.print(n + " ");
			
			for(int i=n; i<=N; i++){
				if(Visit[i] == 0 && G[n][i] == 1){
					deque.add(i);
					Visit[i] = 1;
				}
			}
		}
	}

}
