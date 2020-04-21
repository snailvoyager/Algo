package DataStructures.Search;

public class BinarySearch2D {
	
	static int N = 3;
	static int M = 5;
	static int T = 10;
	static int[][] Map = new int[N][M];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = N * M -1;				//1차원 배열로 생각하고 탐색
		int cnt = 0;
		
		for(int i=0; i<N; i++) {		
			for(int j=0; j<M; j++) {
				Map[i][j] = cnt++;		//저장 값은 오름차순 정렬이 되어있어야 함
			}
		}
		
		while(start <= end) {
			int mid = (start + end) / 2;	// mid 값 탐색
			int midX = mid / M;				// X 좌표
			int midY = mid % M;				// Y 좌표
			
			if(Map[midX][midY] == T) {		//찾으면 출력
				System.out.println(midX + ", " + midY);
				return;
			}
			if(Map[midX][midY] < T) {		//start, end 갱신
				start = mid + 1;
			} else {
				end = mid -1;
			}
		}
	}

}
