package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_��İ���_DP {
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
            P = new int[N+1];           //Ai�� ũ�� P[i-1] * P[i]
            D = new int[N+1][N+1];      //Ai ~ Aj ���� �ּҰ����� Ƚ��
             
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
             
            //Ai ~ Aj ���� ���ϴ� ����� ũ�� P[i-1] * P[j]
             
             
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
A1���� AN������ N���� ����� ���Ϸ��� �մϴ�. �־��� ��Ŀ� ���չ�Ģ�� �� �����ϸ� �ּ����� ������������ ����� ���� �� �ֽ��ϴ�. 
����� �־��� ������� ���� �� ������ 0�� ����ϰ�, ������ ������ ��� ������ �ּ�Ƚ���� ����ϼ���. T���� �׽�Ʈ ���̽�, ���Ϸ��� ����� ��N, N���� ��� ũ�Ⱑ ������ �ΰ� �־����ϴ�.

1<=T<=10, 2<=N<=10


������ A1 (1x2) A2 (2x3) A3(3x2) ����϶��� �Է°� ����Դϴ�.

�Է�
1

3

1 2 2 3 3 2

���
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