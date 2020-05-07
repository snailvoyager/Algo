package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting_Kth {
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        
	        for(int i=0; i<commands.length; i++){
	            int a = commands[i][0];
	            int b = commands[i][1];
	            int c = commands[i][2];

	            ArrayList<Integer> list = new ArrayList<Integer>();
	            for(int k=a-1; k<=b-1; k++){
	                list.add(array[k]);
	            }
	            Collections.sort(list);
	            answer[i] = list.get(c-1);
	        }
	        
	        return answer;
	    }
	}
}
