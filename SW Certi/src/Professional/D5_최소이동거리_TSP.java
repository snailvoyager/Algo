package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_�ּ��̵��Ÿ�_TSP {
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
�����忡 Ư���� �����ϴ� N-1 �׷��� ������ �ִ�. �� �����鿡 ���ʷ� ���� �ֱ� ���� �̵��ϴ� �Ÿ��� ���̱� ���� �� ���� �繫�ǰ� ���� ������ �Ÿ��� ��Ÿ���� NxN�� ǥ�� �������. ǥ���� 1�� �繫��, 2~N�� ������ ��ȣ�̴�. �� ǥ�� ����� �繫�ǿ��� ����� ��� ������ �ѹ� �� �鸥 �� �繫�Ƿ� �ٽ� ���ƿ��� �ּ� �Ÿ��� ���϶�.


N�� 3�� ��� �湮������ 1-2-3-1 �Ǵ� 1-3-2-1�� �ȴ�.

�Ʒ�ǥ���� �繫�ǰ� 2�� ���������� �Ÿ��� L[1][2] = 84���� �� �� �ִ�. (�� ��ȣ-���, �� ��ȣ-����)

3<=N<=10

�Է�
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
���
#1 178
#2 83
#3 268


*/