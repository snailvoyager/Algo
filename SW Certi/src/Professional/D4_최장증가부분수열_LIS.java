package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_최장증가부분수열_LIS {
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
                D[i] = 1;		//모든 길이 1로 초기화
            }
             
            for(int i=1; i<=N; i++) {
                int m = 0;
                for(int j=1; j<i; j++) {
                     
                    if(A[j] < A[i]) {	
                        if(m < D[j])	//i보다 작은 원소 중 증가수열 길이가 가장 긴 것 선택
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
어떤 수열에서 만든 부분 수열의 원소가 오름 차순 정렬된 결과와 같은 경우를 증가 부분 수열이라고 합니다. 이 중 가장 길이가 긴 경우를 찾아 길이를 출력하세요.
입력
테스트케이스 개수 T, 다음 줄 부터 자연수의 개수 N, N개의 자연수 a1부터 an이 차례로 주어집니다.

1<T<=10, 1<N<=1000, 1<=a<=N

출력
#테스트케이스 번호와 답을 출력합니다.

3
5 1 5 3 4 2
5 4 3 5 1 2
10 2 9 5 1 10 6 3 4 8 7

#1 3
#2 2
#3 4
*/