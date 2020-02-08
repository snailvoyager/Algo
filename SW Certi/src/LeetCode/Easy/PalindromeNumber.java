package LeetCode.Easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(122151221));
	}
	
	public static boolean isPalindrome(int x) {
		int compare = x;
		if(x < 0)				//음수면 회문이 아니다
			return false;
		
		int reverse = 0;			//뒤집은 수
		while(x != 0) {
			int rem = x % 10;	//나머지
			x = x / 10;
			
			reverse = reverse * 10 + rem;
		}
		if(reverse == compare)
			return true;
		else
			return false;
	}

}
