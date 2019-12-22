package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ17398_DisjointSet {
	
	static int N, M, Q; 
	static long result = 0L;
	static int[] P, Child;
	static int[][] E;
	static Deque<Integer> dq = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		P = new int[N+1];
		Child = new int[N+1];
		E = new int[M+1][3];
		
		for(int i=1; i<=N; i++) {	//�迭 �ʱ�ȭ
			P[i] = i;
			Child[i] = 1;
		}
		
		for(int i=1; i<=M; i++) {	//���� �Է�
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			E[i][1] = a;
			E[i][2] = b;
		}
		
		for(int i=1; i<=Q; i++) {	//���� ���� ��ȣ Stack�� ����
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			E[c][0] = 1;	//���� ���� ǥ��
			dq.push(c);
		}
		
		make_set();
		
		while(!dq.isEmpty()) {	//�Էµ� ���� ���� �������� Union-Find
			int c = dq.pop();
			int a = E[c][1];
			int b = E[c][2];
			//System.out.println(a+","+b);
			result += union_set(a, b);
		}
		
		System.out.println(result);
	}
	
	public static void make_set() {	//���� ���� �����ϰ� ���� ����
		for(int i=1; i<=M; i++) {
			if(E[i][0] == 0) {
				union_set(E[i][1], E[i][2]);
			}
		}
	}
	
	public static int find_set(int n) {
		if(n != P[n])
			P[n] = find_set(P[n]);
		return P[n];
	}
	
	public static long union_set(int a, int b) {
		int x = find_set(a);
		int y = find_set(b);
		
		if(x == y) return 0;	//���� �����̸� 0
		
		int childX = Child[x];
		int childY = Child[y];
		
		P[y] = x;
		Child[x] += Child[y];	//�ڽ� �� ���ϱ�
		Child[y] = 0;
//		System.out.println(a +", "+b+" : union(" + x + ", " + y + ") : " + childX + " * " + childY);
		
		return 1L * childX * childY;
	}

}
/**
4 4 3
1 2
2 3
3 4
1 4
4
2
3

5
*****************
6 6 2
1 2
2 3
1 3
3 4
4 6
4 5
4
2

9
*/