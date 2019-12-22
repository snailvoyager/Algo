package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class BJ2098_TSP {
 
    static int N;
    static int[][] W;
    static int[][] dp;      //�κа���� �ּҰ�
    static final int INF = 1000000000;
     
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        N = Integer.parseInt(st.nextToken());
        W = new int[N+1][N+1];
        dp = new int[N+1][1<<N];
         
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        for(int i=1; i<=N; i++){         //�迭 �ʱ�ȭ
            Arrays.fill(dp[i], -1);
        }
         
        System.out.println(tsp(1,1));
    }
     
    public static int tsp(int current, int visited){
         
        if(visited == (1<<N)-1)           //��� ������ �湮�� ���
            return W[current][1];       //������ 1�� �������� ���� ����ġ
         
        if(dp[current][visited] >= 0)    //�̹� ���� ��� �޸������̼�
            return dp[current][visited];
         
        int ret = INF;
         
        for(int i=1; i<=N; i++){     //��� �κ�����
             
            int next = i;
             
            if((visited & (1 << (next-1))) != 0)  //i������ �湮�� ��� �н�
                continue;
             
            if(W[current][next] == 0)       //i������ ���� ��ΰ� ���� �� �н�
                continue;
             
//          System.out.println("("+current+", "+ next+" )");
            int temp = W[current][next] + tsp(next, visited + (1 << (next-1)));   //i������ ���� ��� + ������ ���ø� �湮�ϴ� �κ� ����� �ּҰ�
            ret = Math.min(ret, temp);
        }
         
        return dp[current][visited] = ret;
    }
 
}
