package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3����������ĥ�ϱ�_DP {
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
             
            D[1][1] = M[1][1];		//1���� 1���� ���
            D[1][2] = M[1][2];		//1���� 2���� ���
            D[1][3] = M[1][3];		//1���� 3���� ���
            for(int i=2; i<=N; i++) {
                D[i][1] = Math.min(D[i-1][2], D[i-1][3]) + M[i][1];		//1������ ĥ�� �� = ���� ���� 2���� 3���� �� �ּҰ�
                D[i][2] = Math.min(D[i-1][1], D[i-1][3]) + M[i][2];		//2������ ĥ�� �� = ���� ���� 1���� 3���� �� �ּҰ�
                D[i][3] = Math.min(D[i-1][1], D[i-1][2]) + M[i][3];		//3������ ĥ�� �� = ���� ���� 1���� 2���� �� �ּҰ�
            }
            Answer = Math.min(Math.min(D[N][1], D[N][2]), D[N][3]);
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
���� ����� ������ �氡�� ���� 3���� ������ ĥ�ϱ�� �ϰ�, ȭ���ϰ� ���̱� ���� �̿��� �� ������ �ٸ� ������ ĥ�ϱ�� �߽��ϴ�. 
�� ���� 3���� ������ ĥ�� ���� ����� ���� �ٸ��� �� ����� ������ ��, ��ü ���� ĥ�ϴ� �ּ� ����� ����ϼ���. 

���� ��� ������ ����� �־�����,

5 7 6
2 4 8
5 2 3
1������ 1�������� ĥ�ϸ� 5, 2������ ĥ�ϸ� 7, 3������ ĥ�� ���� ����� 6�Դϴ�.

�Է�
�׽�Ʈ���̽��� ���̽��� ���� �� N, �� ���� 1, 2, 3 ������ ĥ�� ���� ����� N���� �ٿ� ���� �־����ϴ�.

3<=N<=100, ����� �� ���� 1,000,000,000�� ���� �ʽ��ϴ�. 

���
#�׽�Ʈ���̽� ��ȣ�� �ּ� ����� ����մϴ�.

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