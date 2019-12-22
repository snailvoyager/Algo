package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_�����ּ��� {
	static int T, N, index;
    static int[] Q;
     
    public static void enQ(int n) {
        int c = ++index;
        int p = c/2;
        int temp = 0;
         
        Q[c] = n;
        while(c > 1 && Q[p] > Q[c]) {
            temp = Q[p];
            Q[p] = Q[c];
            Q[c] = temp;
             
            c = p;
            p = c/2;
        }
    }
     
    public static int sumP() {
        int sum = 0;
        int c = index;
        int p = c/2;
         
        while(c > 0) {
            sum += Q[p];
            c = p;
            p = c/2;
        }
         
        return sum;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            N = Integer.parseInt(br.readLine());
            Q = new int[N+1];
            index = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for(int i=1; i<=N; i++) {
                enQ(Integer.parseInt(st.nextToken()));
            }
             
            System.out.println("#"+test_case + " " + sumP());
        }
         
         
    }
}
/*
���� �ּ����� ������ ���� Ư¡�� ������.

1. �׻� ���� ����Ʈ���� �����Ѵ�.

2. �θ� ����� ��<=�ڽĳ���� ���� �����Ѵ�.

3. ��� ��ȣ�� ��Ʈ�� 1��, ����-������, ��-�Ʒ� ������ 1�� �����ϸ� �ο��ȴ�.

���� ��� {7, 2, 5, 3, 4, 6}�� ���ʷ� �ԷµǸ� ������ ���� Ʈ���� �����ȴ�.



N���� ���� a�� �־����� ���� �ּ����� �����ϰ�, ������ ����� ���� ��忡 ����� ������ ���� ����϶�.

�׽�Ʈ���̽� ���� T�� �־�����, �׽�Ʈ���̽� ����  ������ ���� N, N ���� ������ ���ʷ� �־�����.

1<=T<=10, 1<=N<=100, 1<=a<=10000

�Է�
1 �׽�Ʈ���̽� ����

6 N

7 2 5 3 4 6 N���� ����

���
#1 7 �׽�Ʈ���̽� ��ȣ, ���� ��� �������� ��


3
6
7 2 5 3 4 6
6
5 5 4 3 2 1
8
7 2 6 10 8 5 11 7

#1 7
#2 3
#3 16
*/