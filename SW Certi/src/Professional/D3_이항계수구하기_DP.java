package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_���װ�����ϱ�_DP {
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
(x+y)2 = x2 + 2xy + y2���� xy�� ����� 2�̴�.

(x+y)n���� xayb���� n, a, b�� �־����� xayb�� ����� ���ϴ� ���α׷��� �ۼ��϶�.

1<=n<=70

0<=a,b<=70

���� ����� �ſ� ū ���� �� �����Ƿ� long long���� ����Ͽ� ����ϵ��� �Ѵ�.

�Է�
3 <- �׽�Ʈ���̽� ����

2 1 1 <- n, a, b

3 2 1

5 3 2

���
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