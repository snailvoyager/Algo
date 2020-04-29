package LeetCode.Easy;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(6));
	}
	
	public static int climbStairs(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        if(n>1)
            arr[2] = 2;
        if(n>2)
            arr[3] = 3;
        
        if(n>3){
            for(int i=4; i<=n; i++){
                arr[i] = arr[i-2] + arr[i-1];
            }
        }
        return arr[n];
    }

}
