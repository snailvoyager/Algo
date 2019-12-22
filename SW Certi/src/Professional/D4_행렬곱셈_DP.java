package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_행렬곱셈_DP {
	static int T, Answer, N;
    static int[] P;
    static int[][] D;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            N = Integer.parseInt(br.readLine());
            P = new int[N+1];           //Ai의 크기 P[i-1] * P[i]
            D = new int[N+1][N+1];      //Ai ~ Aj 까지 최소곱셈의 횟수
             
            st = new StringTokenizer(br.readLine());
             
            int k = 0;
            for(int i=1; i<=N; i++) {
                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());
                 
                if(i == 1) {
                    P[k] = temp1;
                    P[k+1] = temp2;
                    k += 2;
                } else {
                    if(P[k-1] == temp1) {
                        P[k] = temp2;
                        k++;
                    } else
                        break;
                }
            }
             
            //Ai ~ Aj 까지 곱하는 경우의 크기 P[i-1] * P[j]
             
             
            for(int l=1; l<N; l++) {
                for(int i=1; i<=N-l; i++) {
                    int j = i+l;
                    int min = 1000000;
                     
                    for(int n=i; n<=j-1; n++) {
                        if(min > D[i][n] + D[n+1][j] + P[i-1]*P[n]*P[j])
                            min = D[i][n] + D[n+1][j] + P[i-1]*P[n]*P[j];
                    }
                    D[i][j] = min;
                }
            }
             
//          System.out.println(Arrays.deepToString(D));
            Answer = D[1][N];
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
A1부터 AN까지의 N개의 행렬을 곱하려고 합니다. 주어진 행렬에 결합법칙을 잘 적용하면 최소한의 곱셈연산으로 결과를 얻을 수 있습니다. 
행렬을 주어진 순서대로 곱할 수 없으면 0을 출력하고, 곱셈이 가능한 경우 곱셈의 최소횟수를 출력하세요. T개의 테스트 케이스, 곱하려는 행렬의 수N, N개의 행렬 크기가 여백을 두고 주어집니다.

1<=T<=10, 2<=N<=10


다음은 A1 (1x2) A2 (2x3) A3(3x2) 행렬일때의 입력과 출력입니다.

입력
1

3

1 2 2 3 3 2

출력
#1 12

3
2
2 3 3 5
3
1 2 2 3 4 2
5
1 2 2 3 3 4 4 5 5 2

#1 30
#2 0
#3 48
*/