package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_이항계수구하기_DP {
	static long Answer;
    static int N, T, A, B;
    static long[][] D;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            D = new long[N+1][N+1];
         
            for(int i=0; i<=N; i++) {
                for(int j=0; j<=i; j++) {
                    if(j == 0)
                        D[i][j] = 1;
                    else if(i == j)
                        D[i][j] = 1;
                    else {
                        D[i][j] = D[i-1][j] + D[i-1][j-1];
                    }
                }
            }
            Answer = D[N][B];
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
(x+y)2 = x2 + 2xy + y2에서 xy의 계수는 2이다.

(x+y)n에서 xayb식의 n, a, b가 주어지면 xayb의 계수를 구하는 프로그램을 작성하라.

1<=n<=70

0<=a,b<=70

이항 계수는 매우 큰 값일 수 있으므로 long long형을 사용하여 출력하도록 한다.

입력
3 <- 테스트케이스 개수

2 1 1 <- n, a, b

3 2 1

5 3 2

출력
#1 2

#2 3

#3 10

3
2 1 1
3 2 1
5 3 2

#1 2
#2 3
#3 10
*/