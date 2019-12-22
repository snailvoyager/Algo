package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_최소이동거리_TSP {
	static int T, N, Answer;
    static int[][] M, D;
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            N = Integer.parseInt(br.readLine());
            M = new int[N+1][N+1];
            D = new int[N+1][1<<N];
             
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++) {
                    M[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(D[i], -1);
            }
            Answer = tsp(1, 1);
            System.out.println("#"+test_case + " " + Answer);
        }
    }
     
    public static int tsp(int c, int v) {
         
        if(v == (1<<N) - 1)
            return M[c][1];
         
        if(D[c][v] >= 0)
            return D[c][v];
         
        int ret = 10000000;
        for(int i=1; i<=N; i++) {
            int next = i;
             
            if((v & (1<<(next-1))) != 0)
                continue;
             
            if(M[c][next] == 0)
                continue;
             
            int temp = M[c][next] + tsp(next, v + (1<<(next-1)));
            ret = Math.min(ret, temp);
        }
        return D[c][v] = ret;
    }
}
/*
골프장에 특별히 관리하는 N-1 그루의 나무가 있다. 이 나무들에 차례로 물을 주기 위해 이동하는 거리를 줄이기 위해 각 관리 사무실과 나무 사이의 거리를 나타내는 NxN의 표를 만들었다. 표에서 1은 사무실, 2~N은 나무의 번호이다. 이 표를 사용해 사무실에서 출발해 모든 나무에 한번 씩 들른 후 사무실로 다시 돌아오는 최소 거리를 구하라.


N이 3인 경우 방문순서는 1-2-3-1 또는 1-3-2-1이 된다.

아래표에서 사무실과 2번 나무사이의 거리는 L[1][2] = 84임을 알 수 있다. (행 번호-출발, 열 번호-도착)

3<=N<=10

입력
3
3
0 84 60 
84 0 34 
60 34 0 
3
0 15 29 
15 0 39 
29 39 0 
5
0 90 64 40 39 
90 0 94 71 38 
64 94 0 57 89 
40 71 57 0 82 
39 38 89 82 0 
출력
#1 178
#2 83
#3 268


*/