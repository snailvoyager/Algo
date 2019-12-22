package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_배낭채우기2_DP {

	static int N, W, Answer;
    static int[] w, v;
    static int[][] memo;
     
    public static void init(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){
                memo[i][j] = -1;
            }
        }
    }
     
    public static int dynamic_memo(int k, int W){
        if(memo[k][W] != -1) return memo[k][W];
        if(k==0 || W==0) return 0;
         
        int case1 = 0, case2 = 0;
         
        if(W >= w[k]){
            case1 = dynamic_memo(k-1, W - w[k]) + v[k];
        }
        case2 = dynamic_memo(k-1, W);
        memo[k][W] = case1 > case2 ? case1 : case2;
        return memo[k][W];
    }
    
    public static int dynamic_iter(int k, int W){
    	for(int i=1; i<=k; i++){
    		for(int j=1; j<=W; j++){
    			int case1=0, case2=0;
    			
    			if(j >= w[i]){		//배낭의 무게가 보석의 무게보다 크면 담을 수 있다
    				case1 = memo[i-1][j-w[i]] + v[i];
    			}
    			case2 = memo[i-1][j];	//배낭에 해당 보석을 안넣을 때
    			memo[i][j] = case1 > case2 ? case1 : case2;
    		}
    	}
    	
    	return memo[k][W];
    }
     
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
         
        w = new int[N+1];
        v = new int[N+1];
        memo = new int[N+1][W+1];
         
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
         
//        init();
//        System.out.println(dynamic_memo(N, W));
        System.out.println(dynamic_iter(N, W));
         
    }
}
/*
한컴 보석상에 도둑이 침입했다. 도둑은 배낭에 보석을 훔치려고 한다. 이때, 훔친 보석의 무게가 W를 넘어가면 배낭이 망가진다. 
각 보석의 값어치와 무게가 주어질 때, 도둑은 총 무게가 W를 넘지 않으면서 보석의 총 값어치가 최대가 되도록 보석을 배낭에 담으려고 한다. 
이때 배낭에 담을 수 있는 최대 값어치를 구하시오.

입력의 첫 줄은 보석의 개수 N(1≤N≤1,000)과 배낭의 용량 W(1≤W≤10,000)가 주어진다. 
둘째 줄부터 N+1줄에는 각 보석의 무게 Wi(1≤Wi≤W)와 값어치 Pi가 주어진다. (단, 보석은 각 종류별로 1개씩임)

출력은 보석의 무게와 값어치가 주어질 때 총 무게가 W를 넘지 않으면서 보석의 총 값어치가 최대가 되는 최대값을 출력한다.

4 16
2 40
5 30
10 50
5 10

90
 */
