package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_���������κм���_LIS {
	static int T, Answer, N;
    static int[] A, D;
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = new int[N+1];
            D = new int[N+1];
             
            for(int i=1; i<=N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                D[i] = 1;		//��� ���� 1�� �ʱ�ȭ
            }
             
            for(int i=1; i<=N; i++) {
                int m = 0;
                for(int j=1; j<i; j++) {
                     
                    if(A[j] < A[i]) {	
                        if(m < D[j])	//i���� ���� ���� �� �������� ���̰� ���� �� �� ����
                            m = D[j];
                    }
                    D[i] = m + 1;
                }
            }
             
            Answer = max(N);
//          System.out.println(Arrays.toString(D));
            System.out.println("#"+test_case + " " + Answer);
        }
    }
     
    public static int max(int n) {
        int max = 0;
        for(int i=1; i<=n; i++) {
            if(max < D[i])
                max = D[i];
        }
        return max;
    }
}
/*
� �������� ���� �κ� ������ ���Ұ� ���� ���� ���ĵ� ����� ���� ��츦 ���� �κ� �����̶�� �մϴ�. �� �� ���� ���̰� �� ��츦 ã�� ���̸� ����ϼ���.
�Է�
�׽�Ʈ���̽� ���� T, ���� �� ���� �ڿ����� ���� N, N���� �ڿ��� a1���� an�� ���ʷ� �־����ϴ�.

1<T<=10, 1<N<=1000, 1<=a<=N

���
#�׽�Ʈ���̽� ��ȣ�� ���� ����մϴ�.

3
5 1 5 3 4 2
5 4 3 5 1 2
10 2 9 5 1 10 6 3 4 8 7

#1 3
#2 2
#3 4
*/