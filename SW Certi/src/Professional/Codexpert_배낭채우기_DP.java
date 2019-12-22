package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_배낭채우기_DP {
	static int N, W, Answer;
    static int[] w, v, D;
    static int[][] memo;
    
    public static int dynamic_iter(){
    	int i, j;
        for(i=1 ; i<=N ; i++){
              for(j=w[i] ; j<=W ; j++){
                    if(D[j]<D[j-w[i]]+v[i]) D[j]=D[j-w[i]]+v[i];
              }
        }
        return D[W];
    	
    	
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
         
        w = new int[N+1];
        v = new int[N+1];
        memo = new int[N+1][W+1];
        D = new int[W+1];
         
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
         
        System.out.println(dynamic_iter());
	}

}
/*
정올 보석상에 도둑이 침입했다. 도둑은 배낭에 보석을 훔치려고 한다. 이때, 훔친 보석의 무게가 W를 넘어가면 배낭이 망가진다. 
각 보석의 값어치와 무게가 주어질 때, 도둑은 총 무게가 W를 넘지 않으면서 보석의 총 값어치가 최대가 되도록 보석을 배낭에 담으려고 한다. 
이때 배낭에 담을 수 있는 최대 값어치를 구하시오.

첫 줄은 보석의 가지 수 N(1≤N≤1,000)과 배낭의 용량 W(1≤W≤10,000)가 주어진다. 
둘째 줄부터 N+1줄에는 각 보석의 무게 Wi(1≤Wi≤W)와 값어치 Pi가 주어진다. (단, 각각의 보석의 개수는 무제한으로 가정함)

보석의 무게와 값어치가 주어질 때 총 무게가 W를 넘지 않으면서, 보석의 총 값어치가 최대가 되는 최대값을 출력한다.

4 14
2 40
5 110
10 200
3 50

300
*/