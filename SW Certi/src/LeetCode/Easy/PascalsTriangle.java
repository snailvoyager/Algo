package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	class Solution {
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
	        for(int i=0; i<numRows; i++){
	            adjList.add(new ArrayList<Integer>());
	        }
	        if(numRows == 0)
	            return adjList;
	        
	        adjList.get(0).add(1);
	        if(numRows == 1)
	            return adjList;
	        
	        for(int i=1; i<numRows; i++){
	            adjList.get(i).add(1);          //첫번째
	            for(int j=1; j<i; j++){
	                int n = adjList.get(i-1).get(j-1) + adjList.get(i-1).get(j);
	                adjList.get(i).add(n);
	            }
	            adjList.get(i).add(1);          //마지막
	        }
	        return adjList;
	    }
	}
}
