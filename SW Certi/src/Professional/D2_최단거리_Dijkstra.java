package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D2_최단거리_Dijkstra {
	static int T, N, E;
    static int[][] Adj;
    static int[] visited, D;
    static int INF = 1000000;
    static int[][] Q;
    static int last;
    static int[] t;
    
    static PriorityQueue<Edge> pQ;
    
    public static class Edge implements Comparable<Edge>{
    	int n1, n2, w;
    	
    	public Edge(int _n1, int _n2, int _w) {
			// TODO Auto-generated constructor stub
    		super();
    		n1 = _n1;
    		n2 = _n2;
    		w = _w;
		}
    	
    	@Override
    	public int compareTo(Edge o) {
    		// TODO Auto-generated method stub
    		return w - o.w;
    	}
    }
     
    public static int dijkstra(int s) {
        visited[s] = 1;
        D = Adj[s];
         
//      System.out.println(Arrays.toString(D));
        int cnt = N;
         
         
        while(cnt > 0) {
            int minD = INF;
            int idxD = 0;
             
            for(int i=0; i<=N; i++) {
                if(visited[i] == 0 && D[i] < minD) {
                    minD = D[i];
                    idxD = i;
                }
            }
             
            visited[idxD] = 1;
            for(int i=0; i<=N; i++) {
                if(visited[i] == 0)
                    D[i] = Math.min(D[i], D[idxD] + Adj[idxD][i]);
            }
             
            cnt = 0;
            for(int i=0; i<=N; i++) {
                if(visited[i] == 0)
                    cnt++;
            }
        }
         
        return D[N];
    }
    
    public static int dijkstra2(){
    	last = 0;
    	t = new int[3]; //deQ 값 저장
//    	Q = new int[E+1][3];
    	pQ = new PriorityQueue<Edge>();
    	
    	visited[0] = 1;
    	for(int i=1; i<=N; i++){
    		if(Adj[0][i] != 0 && Adj[0][i] != INF){
    			pQ.add(new Edge(0, i, Adj[0][i]));
    			last++;
    		}
    		D[i] = Adj[0][i];
    	}
    	
    	while(last>0){
    		Edge e = pQ.poll();
    		--last;
    		t[0] = e.n1;
    		t[1] = e.n2;
    		t[2] = e.w;
    		
    		visited[t[1]] = 1;
    		for(int i=0; i<=N; i++){
    			if(Adj[t[1]][i] != 0 && Adj[t[1]][i] != INF){	//경유지에서 i로 가는 경로가 있을 때
    				if(D[i] > D[t[1]] + Adj[t[1]][i]){			//경유지를 거쳐 i까지 가는 비용이 적으면
    					D[i] = D[t[1]] + Adj[t[1]][i];			//i까지 가는 경로를 업데이트
    					pQ.add(new Edge(t[1], i, Adj[t[1]][i]));//
    					last++;
    				}
    			}
    		}
    		
    	}
    	return D[N];
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Adj = new int[N+1][N+1];
            visited = new int[N+1];
            D = new int[N+1];
             
            for(int i=0; i<=N; i++) {
                for(int j=0; j<=N; j++) {
                    if(i == j) {
                        Adj[i][j] = 0;
                        continue;
                    }
                    Adj[i][j] = INF;
                }
            }
             
            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                 
                Adj[n1][n2] = w;
            }
             
            System.out.println("#"+test_case + " " + dijkstra2());
        }
    }
}
/*
0번 정점에서 출발해 마지막 N번 정점에 도착할 때까지의 최단 거리를 구하려고 합니다. 출발 도착 사이의 모든 정점을 지나야 하는 것은 아닙니다.
입력
1 -> 테스트 케이스 T
2 3 -> 마지막 노드 N, 간선의 수 E
0 1 1 -> 출발  n1, 도착 n2, 거리 w
0 2 1
1 2 6

0<N<=1000, 

출력
#1 1

3
2 3
0 1 1
0 2 1
1 2 6
4 7
0 1 9
0 2 3
0 3 7
1 4 2
2 3 8
2 4 1
3 4 8
4 6
0 1 10
0 2 7
1 4 2
2 3 10
2 4 3
3 4 10

#1 1
#2 4
#3 10
*/