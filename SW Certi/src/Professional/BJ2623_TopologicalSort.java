package Professional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2623_TopologicalSort {
	static int N, M;
	static int[] Indegree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Indegree = new int[N+1];
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<K; j++) {
				int post = Integer.parseInt(st.nextToken());
				adjList.get(pre).add(post);
				Indegree[post]++;
				pre = post;
			}
		}
		
		Queue<Integer> searchQ = new LinkedList<Integer>();
		Queue<Integer> resultQ = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(Indegree[i] == 0)
				searchQ.offer(i);
		}
		
		while(!searchQ.isEmpty()) {
			int curr = searchQ.poll();
			resultQ.offer(curr);
			
			for(int next : adjList.get(curr)) {
				Indegree[next]--;
				if(Indegree[next] == 0)
					searchQ.offer(next);
			}
		}
		
		if(resultQ.size() != N)
			bw.write("0");
		else {
			while(!resultQ.isEmpty()) {
				bw.write(resultQ.poll()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
/*
6 3
3 1 4 3
4 6 2 5 4
2 2 3

1
6
2
5
4
3
*/