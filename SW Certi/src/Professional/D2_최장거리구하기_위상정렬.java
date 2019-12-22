package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D2_����Ÿ����ϱ�_�������� {
	static int T, N, E, indQ;
    static int[][] Adj;
    static int[] visited, D, I, Q;
       
    public static void sort2() {
        Queue<Integer> q = new LinkedList<>();  
         
        for(int i=0; i<=N; i++) {
            if(I[i] == 0) {
                q.add(i);
            }
        }
         
        while(!q.isEmpty()) {
            int t = q.poll();
             
            int max = 0;
             
            for(int i=0; i<=N; i++) {
                if(Adj[i][t] != 0) {
                    if(max < D[i] + Adj[i][t])
                        max = D[i] + Adj[i][t];
                }
            }
            D[t] = max;
             
            for(int i=0; i<=N; i++) {
                if(Adj[t][i] != 0) {
                    I[i]--;
                    if(I[i] == 0)
                        q.add(i);
                }
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Adj = new int[N+1][N+1];
            visited = new int[N+1];
            D = new int[N+1];
            I = new int[N+1];
            Q = new int[N+1];
             
            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                 
                Adj[n1][n2] = w;
                I[n2]++;
            }
             
            sort2();
            System.out.println("#"+test_case + " " + D[N] );
        }
         
    }
}
/*
0�� �������� ����� N�� ������ ������ �������� �Ÿ��� ���� ����Ѵ�. �̶� ���� ��ΰ� �ִ� ��� ���� �� �Ÿ��� ���� ����Ѵ�. ��� ���� ������ ��� ������ ������ �ϴ� ���� �ƴϴ�.

������ ���� N�� ������ �� E�� �־�����.

���(V1) ����(V2) �Ÿ�(W) ������ ���� ����ŭ �־�����.

���������� �̵��� ��� ���� �������θ� �����ϴ�.

0<N<=1000, 1<=W<=10

�Է�
1 <- �׽�Ʈ���̽� ����

4 7 <- N�� E

0 1 4 <- ���, ����, �Ÿ�

0 4 5

1 2 8

1 3 3

2 4 1

3 4 4

���
#1 13

3
2 3
0 1 1
0 2 1
1 2 6
4 7
0 1 9
0 2 3
0 3 7
1 4 2
2 3 8
2 4 1
3 4 8
4 6
0 1 10
0 2 7
1 4 2
2 3 10
2 4 3
3 4 10

#1 7
#2 19
#3 27
*/