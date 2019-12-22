package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_�׷쳪����_DisjointSet {
	static int N, M, T;
    static int[] A;
    static int Answer;
     
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
         
        A[b] = rootA;
    }
     
    public static int find(int n) {
        while(A[n] != n)
            n = A[n];
         
        return n;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N+1];
             
            for(int i=1; i<=N; i++) {    //��Ʈ��� �ʱ�ȭ
                A[i] = i;
            }
             
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
             
            Answer = 0;
            for(int i=1; i<=N; i++) {
                if(A[i] == i)
                    Answer++;
            }
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
�߿�Ȱ������ ���� ���� ����� ���� ������� �⼮��ȣ�� ���̿� ���� �����Ͽ���. 1������ N������ ���� ��ȣ�� ����, ������ ���̴� ��� M���̾���. 
Ư���� ���� ���� �ǰ� ���� ����� ������ ���̸� �������� �ʾұ� ������ ���̿� ��ȣ�� ���� ��쵵 �ְ�, 
���� ��� �� ���� �ǰ� �;� ���� ���� ���̸� �����ϰų�, ���� ���� �� ģ���� ��� ��쵵 �ִ�. 
ȥ���� ��쵵 1���� ����Ѵٸ� ��� �� ���� ���� ����������� ����϶�.

2<=N<=100, 1<=M<=1000

�Է�
�׽�Ʈ���̽� ��, N, M, M���� ���̿� ���� �� ����� ��ȣ�� ���ʷ� �־�����.
���
#�ڿ� �׽�Ʈ���̽� ��ȣ, �� ���� ���� ����������� ����Ѵ�.

3
5 2
1 2 3 4
5 3
1 2 2 3 4 5
7 4
2 3 4 5 4 6 4 7

#1 3
#2 2
#3 3
*/