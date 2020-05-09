package programmers;

import java.util.HashSet;

public class FullScan_FindPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("011"));
	}

    public static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        char[] arr = numbers.toCharArray();
        boolean[] visit = new boolean[arr.length];
        //nP1 + nP2 + nP3 +....순열
        for(int i=1; i<=arr.length; i++){
            char[] temp = new char[i];
            perm(arr, arr.length, i, 0, visit, temp, set);
        }
        System.out.println(set.toString());
        return set.size();
    }
    
    public static void perm(char[] arr, int n, int r, int depth, boolean[] visit, char[] temp, HashSet<Integer> set){ //순열
        if(depth == r){
            String str = "";
            for(int i=0; i<r; i++)
                str += temp[i];
            int c = Integer.parseInt(str);
            if(checkPrime(c))
                    set.add(c);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                temp[depth] = arr[i];
                perm(arr, n, r, depth+1, visit, temp, set);
                visit[i] = false;
            }
        }
    }
    
    public static boolean checkPrime(int n){		//소수 찾기
        if(n == 1 || n ==0)  return false;
        
        for(int i=2; i<=n/2; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
