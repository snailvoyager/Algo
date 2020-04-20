package im;

public class PowerSet {
	static char[] D = {'A', 'B', 'C'};
	static boolean[] Visit = new boolean[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//비트 연산 구현
		for(int i=0; i<(1<<3); i++) {		// 2^3 탐색
			for(int j=0; j<3; j++) {
				if((i & (1<<j)) != 0) {		// &연산
					System.out.print(D[j] + " ");
				}
			}
			System.out.println();
		}
		
		System.out.println("\n재귀구현 : ");
		powerSet(3, 0);
	}
	
	public static void powerSet(int n, int idx) {
		if(n == idx) {
			for(int i=0; i<n; i++) {
				if(Visit[i])
					System.out.print(D[i] + " ");
			}
			System.out.println();
			return;
		}
		Visit[idx] = true;
		powerSet(n, idx+1);
		
		Visit[idx] = false;
		powerSet(n, idx+1);
	}

}
