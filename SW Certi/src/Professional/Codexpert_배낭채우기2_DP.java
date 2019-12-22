package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_�賶ä���2_DP {

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
    			
    			if(j >= w[i]){		//�賶�� ���԰� ������ ���Ժ��� ũ�� ���� �� �ִ�
    				case1 = memo[i-1][j-w[i]] + v[i];
    			}
    			case2 = memo[i-1][j];	//�賶�� �ش� ������ �ȳ��� ��
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
���� ������ ������ ħ���ߴ�. ������ �賶�� ������ ��ġ���� �Ѵ�. �̶�, ��ģ ������ ���԰� W�� �Ѿ�� �賶�� ��������. 
�� ������ ����ġ�� ���԰� �־��� ��, ������ �� ���԰� W�� ���� �����鼭 ������ �� ����ġ�� �ִ밡 �ǵ��� ������ �賶�� �������� �Ѵ�. 
�̶� �賶�� ���� �� �ִ� �ִ� ����ġ�� ���Ͻÿ�.

�Է��� ù ���� ������ ���� N(1��N��1,000)�� �賶�� �뷮 W(1��W��10,000)�� �־�����. 
��° �ٺ��� N+1�ٿ��� �� ������ ���� Wi(1��Wi��W)�� ����ġ Pi�� �־�����. (��, ������ �� �������� 1������)

����� ������ ���Կ� ����ġ�� �־��� �� �� ���԰� W�� ���� �����鼭 ������ �� ����ġ�� �ִ밡 �Ǵ� �ִ밪�� ����Ѵ�.

4 16
2 40
5 30
10 50
5 10

90
 */
