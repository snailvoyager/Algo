package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class BJ2098_TSP {
 
    static int N;
    static int[][] W;
    static int[][] dp;      //부분경로의 최소값
    static final int INF = 1000000000;
     
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        N = Integer.parseInt(st.nextToken());
        W = new int[N+1][N+1];
        dp = new int[N+1][1<<N];
         
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        for(int i=1; i<=N; i++){         //배열 초기화
            Arrays.fill(dp[i], -1);
        }
         
        System.out.println(tsp(1,1));
    }
     
    public static int tsp(int current, int visited){
         
        if(visited == (1<<N)-1)           //모든 정점을 방문한 경우
            return W[current][1];       //시작점 1번 정점으로 가는 가중치
         
        if(dp[current][visited] >= 0)    //이미 가본 경로 메모이제이션
            return dp[current][visited];
         
        int ret = INF;
         
        for(int i=1; i<=N; i++){     //모든 부분집합
             
            int next = i;
             
            if((visited & (1 << (next-1))) != 0)  //i정점에 방문한 경우 패스
                continue;
             
            if(W[current][next] == 0)       //i정점에 가는 경로가 없을 때 패스
                continue;
             
//          System.out.println("("+current+", "+ next+" )");
            int temp = W[current][next] + tsp(next, visited + (1 << (next-1)));   //i정점에 가는 비용 + 나머지 도시를 방문하는 부분 경로의 최소값
            ret = Math.min(ret, temp);
        }
         
        return dp[current][visited] = ret;
    }
 
}
