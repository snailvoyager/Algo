package programmers;

import java.util.ArrayList;
import java.util.List;

public class FullScan_MockTest {
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = {};
	        List<Integer> list = new ArrayList<>();
	        int[] arr1 = {1, 2, 3, 4, 5};
	        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        int answer1 = 0;
	        int answer2 = 0;
	        int answer3 = 0;
	        
	        for(int i=0; i<answers.length; i++){
	            if(answers[i] == arr1[i % 5])
	                answer1++;
	            if(answers[i] == arr2[i % 8])
	                answer2++;
	            if(answers[i] == arr3[i % 10])
	                answer3++;
	        }

	        int max = Math.max(Math.max(answer1, answer2), answer3);
	        if(max == answer1)
	            list.add(1);
	        if(max == answer2)
	            list.add(2);
	        if(max == answer3)
	            list.add(3);
	        
	        answer = new int[list.size()];
	        for(int i=0; i<list.size(); i++){
	            answer[i] = list.get(i);
	        }
	        return answer;
	    }
	}
}
