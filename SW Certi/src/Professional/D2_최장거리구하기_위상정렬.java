package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D2_최장거리구하기_위상정렬 {
	static int T, N, E, indQ;
    static int[][] Adj;
    static int[] visited, D, I, Q;
       
    public static void sort2() {
        Queue<Integer> q = new LinkedList<>();  
         
        for(int i=0; i<=N; i++) {
            if(I[i] == 0) {
                q.add(i);
            }
        }
         
        while(!q.isEmpty()) {
            int t = q.poll();
             
            int max = 0;
             
            for(int i=0; i<=N; i++) {
                if(Adj[i][t] != 0) {
                    if(max < D[i] + Adj[i][t])
                        max = D[i] + Adj[i][t];
                }
            }
            D[t] = max;
             
            for(int i=0; i<=N; i++) {
                if(Adj[t][i] != 0) {
                    I[i]--;
                    if(I[i] == 0)
                        q.add(i);
                }
            }
        }
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
            I = new int[N+1];
            Q = new int[N+1];
             
            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                 
                Adj[n1][n2] = w;
                I[n2]++;
            }
             
            sort2();
            System.out.println("#"+test_case + " " + D[N] );
        }
         
    }
}
/*
0번 정점에서 출발해 N번 정점에 도착할 때까지의 거리의 합을 출력한다. 이때 여러 경로가 있는 경우 가장 먼 거리의 합을 출력한다. 출발 도착 사이의 모든 정점을 지나야 하는 것은 아니다.

마지막 정점 N과 간선의 수 E가 주어진다.

출발(V1) 도착(V2) 거리(W) 정보가 간선 수만큼 주어진다.

정점사이의 이동은 출발 도착 방향으로만 가능하다.

0<N<=1000, 1<=W<=10

입력
1 <- 테스트케이스 개수

4 7 <- N과 E

0 1 4 <- 출발, 도착, 거리

0 4 5

1 2 8

1 3 3

2 4 1

3 4 4

출력
#1 13

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

#1 7
#2 19
#3 27
*/