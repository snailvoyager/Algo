package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3가지색으로칠하기_DP {
	static int T, Answer, N;
    static int[][] M, D;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            N = Integer.parseInt(br.readLine());
            M = new int[N+1][4];
            D = new int[N+1][4];
             
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                M[i][1] = Integer.parseInt(st.nextToken());
                M[i][2] = Integer.parseInt(st.nextToken());
                M[i][3] = Integer.parseInt(st.nextToken());
            }
             
            D[1][1] = M[1][1];		//1번집 1번색 비용
            D[1][2] = M[1][2];		//1번집 2번색 비용
            D[1][3] = M[1][3];		//1번집 3번색 비용
            for(int i=2; i<=N; i++) {
                D[i][1] = Math.min(D[i-1][2], D[i-1][3]) + M[i][1];		//1번색을 칠할 때 = 이전 집의 2번색 3번색 중 최소값
                D[i][2] = Math.min(D[i-1][1], D[i-1][3]) + M[i][2];		//2번색을 칠할 때 = 이전 집의 1번색 3번색 중 최소값
                D[i][3] = Math.min(D[i-1][1], D[i-1][2]) + M[i][3];		//3번색을 칠할 때 = 이전 집의 1번색 2번색 중 최소값
            }
            Answer = Math.min(Math.min(D[N][1], D[N][2]), D[N][3]);
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
축제 행렬이 지나는 길가의 집을 3가지 색으로 칠하기로 하고, 화려하게 보이기 위해 이웃한 집 끼리는 다른 색으로 칠하기로 했습니다. 
각 집을 3가지 색으로 칠할 때의 비용이 각각 다르고 이 비용이 제공될 때, 전체 집을 칠하는 최소 비용을 출력하세요. 

예를 들어 다음과 비용이 주어지면,

5 7 6
2 4 8
5 2 3
1번집을 1번색으로 칠하면 5, 2번으로 칠하면 7, 3번으로 칠할 때의 비용이 6입니다.

입력
테스트케이스와 케이스별 집의 수 N, 각 집을 1, 2, 3 색으로 칠할 때의 비용이 N개의 줄에 걸쳐 주어집니다.

3<=N<=100, 비용의 총 합은 1,000,000,000을 넘지 않습니다. 

출력
#테스트케이스 번호와 최소 비용을 출력합니다.

3
3
5 7 6
2 4 8
5 2 3
3
7 4 6
8 5 10
6 5 5
5
1 7 4
9 10 5
7 6 8
1 4 6
7 9 10

#1 10
#2 16
#3 22
*/