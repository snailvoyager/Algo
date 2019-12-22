package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_�ǳʶٱ�_DP {
	static int T, Answer, N, M;
    static int[][] A, D;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            A = new int[N+1][M+1];
            D = new int[N+1][M+1];
             
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            D[1][1] = 1;
             
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    for(int k=1; k<=j-1; k++) {		//���ʿ��� �� �� �ִ� ���
                        if(A[i][k] == j-k)
                            D[i][j] += D[i][k];
                    }
                     
                    for(int k=1; k<=i-1; k++) {		//������ �� �� �ִ� ���
                        if(A[k][j] == i-k)
                            D[i][j] += D[k][j];
                    }
                }
            }
             
            Answer = D[N][M];
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
NxM ũ���� �����ǿ��� �� ĭ���� �������̳� �Ʒ������� �ǳʶ� �� �ִ� ���ڰ� �����ֽ��ϴ�. �� ���������� ��� �� �� ������ �Ʒ�ĭ�� ��Ȯ�ϰ� �����ϴ� ����� ���� ����ϼ���.  
�Է�
�׽�Ʈ���̽� ������ N, M, �� ĭ�� ���� a�� �־����ϴ�.

1<T<=10, 5<=N, M<=20, 1<=a<=3

���
#�׽�Ʈ���̽� ��ȣ�� ���� ����մϴ�.

3
5 5
2 3 1 3 1 
2 1 1 1 1 
3 1 2 1 3 
3 1 2 3 2 
3 1 2 3 2 
5 5
2 1 2 3 3 
1 1 2 3 1 
1 3 1 2 1 
2 2 1 2 3 
2 3 2 2 3 
5 10
1 1 1 1 1 2 1 2 3 2 
1 1 2 1 2 3 3 2 3 2 
2 1 3 2 3 1 2 1 2 1 
2 2 3 2 1 3 2 1 3 3 
1 2 1 3 3 2 3 3 3 3

#1 1
#2 2
#3 12
*/