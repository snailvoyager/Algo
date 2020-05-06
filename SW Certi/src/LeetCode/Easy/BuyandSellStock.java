package LeetCode.Easy;

public class BuyandSellStock {
	class Solution {
	    public int maxProfit(int[] prices) {
	        int result = 0;
	        int buy = Integer.MAX_VALUE;
	        int sell = 0;
	        
	        for(int i=0; i<prices.length; i++){
	            if(prices[i] < buy){
	                buy = prices[i];
	                continue;
	            }
	            if(buy != Integer.MAX_VALUE){
	                if(prices[i] - buy > result){
	                    result = prices[i] - buy;
	                }
	            }
	            
	        }
	        
	        
	        return result;
	    }
	}
}
