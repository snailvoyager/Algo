package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codexpert_�賶ä���_DP {
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
���� ������ ������ ħ���ߴ�. ������ �賶�� ������ ��ġ���� �Ѵ�. �̶�, ��ģ ������ ���԰� W�� �Ѿ�� �賶�� ��������. 
�� ������ ����ġ�� ���԰� �־��� ��, ������ �� ���԰� W�� ���� �����鼭 ������ �� ����ġ�� �ִ밡 �ǵ��� ������ �賶�� �������� �Ѵ�. 
�̶� �賶�� ���� �� �ִ� �ִ� ����ġ�� ���Ͻÿ�.

ù ���� ������ ���� �� N(1��N��1,000)�� �賶�� �뷮 W(1��W��10,000)�� �־�����. 
��° �ٺ��� N+1�ٿ��� �� ������ ���� Wi(1��Wi��W)�� ����ġ Pi�� �־�����. (��, ������ ������ ������ ���������� ������)

������ ���Կ� ����ġ�� �־��� �� �� ���԰� W�� ���� �����鼭, ������ �� ����ġ�� �ִ밡 �Ǵ� �ִ밪�� ����Ѵ�.

4 14
2 40
5 110
10 200
3 50

300
*/