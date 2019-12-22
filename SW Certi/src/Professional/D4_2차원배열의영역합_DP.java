package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_2차원배열의영역합_DP {
	static int N, T, Answer, r1, r2, c1, c2;
    static int[][] M, D;
    static int[] Sum;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            N = Integer.parseInt(br.readLine());
            M = new int[N+1][N+1];
            D = new int[N+1][N+1];
             
            int k = 0;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    M[i][j] = (k++)%10+1;
                }
            }
             
            for(int i=1; i<=N; i++) {				//각 영영의 합을 모두 구함
                for(int j=1; j<=N; j++) {
                    D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + M[i][j];	//b + c - a + d
                }
            }
             
            for(int i=1; i<=N; i++) {						//각 모서리 좌표에 해당하는 영역합 구하기. 왼쪽 상단은 두번 중복 제거로 한번 플러스.
                st = new StringTokenizer(br.readLine());
                r1 = Integer.parseInt(st.nextToken());
                c1 = Integer.parseInt(st.nextToken());
                r2 = Integer.parseInt(st.nextToken());
                c2 = Integer.parseInt(st.nextToken());
                 
                Answer += D[r2][c2] - D[r2][c1-1] - D[r1-1][c2] + D[r1-1][c1-1];
            }
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
NxN 크기의 배열에 정해진 규칙대로 숫자를 채웁니다. 이후에는 N개의 직사각형 영역에 대한 왼쪽 위(r1, c1)와 오른쪽 아래 좌표(r2, c2)가 주어집니다.  
각 영역에 있는 숫자의 합을 모두 더해 출력하는 프로그램을 작성하세요.

NxN 크기의 배열 m[][]의 각 칸은 아래의 규칙대로 숫자가 채워집니다.

int k = 0;
for(int i=1; i<=N; i++)
{
    for(int j=1; j<=N; j++)
    {
        m[i][j]= (k++)%10+1;
    }
}

3
3
1 2 3 3
2 1 3 3
2 2 2 3
5
2 3 2 5
1 1 2 3
1 1 5 2
1 3 3 4
2 2 3 5
10
7 2 10 4
4 8 8 8
2 5 9 8
2 1 8 4
2 1 4 3
1 5 6 10
1 4 8 9
2 1 3 7
4 3 5 9
3 5 9 9

#1 83
#2 168
#3 1339
*/