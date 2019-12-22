package Professional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codexpert1057 {

	static int N, W;
    static int[] C;
    static int[] memo;
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = new int[N+1];
         
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            C[i] = Integer.parseInt(st.nextToken());
        }
         
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        memo = new int[W+1];
         
        int Answer = dynamic_iter(W);
        if(Answer == 4096)
        	bw.write("impossible\n");
        else
        	bw.write(Answer + "\n");

//        bw.write(Arrays.toString(memo));
        bw.close();
    }
     
    public static int dynamic_memo(int money){
        if(memo[money] != 0) return memo[money];
        if(money == 0) return memo[money] = 0;
         
        int min = 0xfff;
        for(int i=1; i<=N; i++){
            if(money < C[i]) continue;
             
            int ret = dynamic_memo(money - C[i]);
            if(min > ret) min = ret;
        }
         
        return memo[money] = min + 1;
    }
    
    public static int dynamic_iter(int money){
    	memo[0] = 0;
    	
    	for(int i=1; i<=money; i++){
    		int min = 0xfff;
    		
    		for(int j=1; j<=N; j++){
    			if(i < C[j]) continue;
    			
    			int ret = memo[i - C[j]];
    			
    			if(min > ret) min = ret;
    		}
    		memo[i] = min + 1;
    	}
    	
    	return memo[money];
    }

}
