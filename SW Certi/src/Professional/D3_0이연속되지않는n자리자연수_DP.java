package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_0�̿��ӵ����ʴ�n�ڸ��ڿ���_DP {
	 static int T, Answer, N;
	    static int[][] D;
	 
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        // TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	         
	        T = Integer.parseInt(br.readLine());
	        for(int test_case=1; test_case<=T; test_case++) {
	            Answer = 0;
	            N = Integer.parseInt(br.readLine());
	            D = new int[2][N+1];
	             
	            D[0][1] = 0;			//ù��°�� 0���� �����ϴ� ����� ��
	            D[1][1] = 1;			//ù��°�� 1�� �����ϴ� ����� ��
	            for(int i=2; i<=N; i++) {
	                D[0][i] = D[1][i-1];			//�տ� 1�� ������ 0�� �� �� ����
	                D[1][i] = D[0][i-1] + D[1][i-1];	//�տ� 1�̵� 0�̵� �׻� 1�� �� �� ����. 
	            }
	             
	            Answer = D[0][N] + D[1][N];
	             
	            System.out.println("#"+test_case + " " + Answer);
	        }
	    }
}
/*
1�� �����ϴ� n��Ʈ ���������� 0�� �������� ��Ÿ���� �ʴ� ����� ���� ���Ͻÿ�.

�Է�
3<=n<=30

�׽�Ʈ ���̽� ������ �� ���̽� ���� n�� �־����ϴ�.

���
#�׽�Ʈ���̽� ��ȣ�� ����� ���� ����մϴ�.

3
4
8
10

#1 5
#2 34
#3 89

*/