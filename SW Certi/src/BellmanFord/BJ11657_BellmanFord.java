package BellmanFord;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11657_BellmanFord {
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static int[] D;
	static ArrayList<Edge> list = new ArrayList<Edge>();
	
	static class Edge{
		int from, to, cost;
		
		Edge(int _from, int _to, int _cost){
			this.from = _from;
			this.to = _to;
			this.cost = _cost;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N+1];
		for(int i=0; i<=N; i++) {
			D[i] = INF;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(from, to, cost));
		}
		
		boolean cycleFlag = false;
		D[1] = 0;
		
		for(int i=1; i<=N; i++) {
			for(Edge e : list) {
				if(D[e.from]!= INF && D[e.to]> D[e.from]+e.cost) {
					D[e.to] = D[e.from]+ e.cost;
					if(i == N)
						cycleFlag = true;
				}
			}
		}
		
		if(cycleFlag)
			bw.write("-1");
		else {
			for(int i=2; i<=N; i++) {
				if(D[i] == INF)
					bw.write("-1\n");
				else
					bw.write(D[i]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
/**
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

4
3
 */
