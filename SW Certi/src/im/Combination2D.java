package im;

public class Combination2D {
	static int N = 3;
	static int M = 3;
	static int R = 3;
	static int cnt;
	static int[][] Map = new int[N][M];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		combi(0, 0);
		System.out.println(cnt);
	}

	public static void combi(int start, int depth) {
		if(depth == R) {				//뽑은 수 다되면 출력
			print();
			cnt++;
			return;
		}
		for(int i=start; i<N*M; i++) {		//1차원 배열로 생각하고 탐색
			int x = i / M;			// X좌표
			int y = i % M;			// Y좌표
			
			if(Map[x][y] == 0) {
				Map[x][y] = 1;
				combi(i+1, depth+1);
				Map[x][y] = 0;
			}
		}
		
	}
	
	public static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
