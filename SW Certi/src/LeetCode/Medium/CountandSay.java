package LeetCode.Medium;

public class CountandSay {
	class Solution {
	    public String countAndSay(int n) {
	       
	        if(n == 1)
	            return "1";
	        if(n == 2)
	            return "11";
	        
	        String result = "11";
	        StringBuilder sb = new StringBuilder();
	        for(int i=3; i<=n; i++){
	            sb = new StringBuilder();
	            int k = result.charAt(0) - 48;
	            int j = 1;
	            int m = 1;
	            while(j < result.length()){
	                int o = result.charAt(j) - 48;
	                if(k == o){
	                    m++;
	                } else{
	                    sb.append(m);
	                    sb.append(k);
	                    k = o;
	                    m = 1;
	                }
	                j++;
	            }
	            sb.append(m);
	            sb.append(k);
	            result = sb.toString();
	        }
	        
	        return result;
	    }
	}
}
