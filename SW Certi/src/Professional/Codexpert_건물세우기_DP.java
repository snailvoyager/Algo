package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_�ǹ������_DP {

	static int N, Answer;
	static int[] B;
	static int[][] A, D;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		B = new int[N+1];
		A = new int[N+1][N+1];
		D = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++){
			D[1][i] = A[1][i];
		}
		
		for(int i=2; i<=N; i++){
			for(int j=1; j<=N; j++){
				
			}
		}
		
		System.out.println(Answer);
		for(int i=1; i<=N; i++){
			System.out.print(B[i] + " ");
		}
	}

}
/*
(��)���ÿ����� ���� ���� ������ ���� ���� ��ȹ�̴�. �׷��� ������ ���� ��Ҹ� �����Ͽ���. �׸��� �� ������ �� ��ҿ� ���� ��쿡 ��� ����� �����Ͽ���. ���� �� �Ʒ��� ǥ�� ����
 
             1 2 3
           A 4 7 3
           B 2 6 1
           C 3 9 4
 
A, B, C �� �ǹ��� ��Ÿ����, 1, 2, 3�� ��Ҹ� ��Ÿ����. ���� �� �ǹ� B�� ��� 1�� ����� ����� 2�� ���, ��� 2�� ����� ����� 6, ��� 3�� ����� ����� 1��ŭ ���. ���� �� ��ҿ��� �� �ǹ��ۿ� ���� �� ����. ���� A�� ��� 2��, B�� ��� 3��, C�� 1�� ����� ��ü ����� 7+1+3 = 11�� �ʿ��ϴ�. �׷��� A�� 3, B�� 1, C�� 2�� ����� 3+2+9 = 14 �� �ʿ��ϴ�.
 
�� ������ ��� ��ҿ� ����� ����� ���� �ּҰ� �Ǵ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է� ������ ù ���� ������ ���� n(1��n��20)�� ����ִ�.
�� ���� n �ٿ��� �� �ǹ��� �� ��ҿ� ���� ��쿡 ��� ����� �Էµȴ�. ���� �� �� ���� n���� ���� �Էµȴ�.
����� ��Ÿ���� ���� ������ 1�̻� 100�̸��̴�.

ù �ٿ��� �ּҺ���� ����Ѵ�.
��° �ٿ��� �ǹ��� ���� ��ҵ��� ���ĺ� ������ ���� ��ĭ�� �ϳ��� �ΰ� ����Ѵ�.

4
11 12 18 40
14 15 13 22
11 17 19 23
17 14 20 28

61
1 3 4 2
*/