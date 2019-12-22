package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_건물세우기_DP {

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
(주)정올에서는 여러 개의 빌딩을 새로 지을 계획이다. 그래서 빌딩을 세울 장소를 선정하였다. 그리고 각 빌딩을 각 장소에 세울 경우에 드는 비용을 추정하였다. 예를 들어서 아래의 표를 보자
 
             1 2 3
           A 4 7 3
           B 2 6 1
           C 3 9 4
 
A, B, C 는 건물을 나타내고, 1, 2, 3은 장소를 나타낸다. 예를 들어서 건물 B를 장소 1에 세우면 비용이 2가 들고, 장소 2에 세우면 비용이 6, 장소 3에 세우면 비용이 1만큼 든다. 물론 한 장소에는 한 건물밖에 세울 수 없다. 만일 A를 장소 2에, B를 장소 3에, C를 1에 세우면 전체 비용이 7+1+3 = 11이 필요하다. 그런데 A를 3, B를 1, C를 2에 세우면 3+2+9 = 14 가 필요하다.
 
각 빌딩을 어느 장소에 세우면 비용의 합이 최소가 되는지 구하는 프로그램을 작성하시오.

입력 파일의 첫 줄은 빌딩의 개수 n(1≤n≤20)이 들어있다.
그 다음 n 줄에는 각 건물을 각 장소에 세울 경우에 드는 비용이 입력된다. 물론 각 줄 에는 n개의 수가 입력된다.
비용을 나타내는 수의 범위는 1이상 100미만이다.

첫 줄에는 최소비용을 출력한다.
둘째 줄에는 건물을 세울 장소들을 알파벳 순서에 따라 빈칸을 하나씩 두고 출력한다.

4
11 12 18 40
14 15 13 22
11 17 19 23
17 14 20 28

61
1 3 4 2
*/