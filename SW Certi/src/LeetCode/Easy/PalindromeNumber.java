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
		if(x < 0)				//������ ȸ���� �ƴϴ�
			return false;
		
		int reverse = 0;			//������ ��
		while(x != 0) {
			int rem = x % 10;	//������
			x = x / 10;
			
			reverse = reverse * 10 + rem;
		}
		if(reverse == compare)
			return true;
		else
			return false;
	}

}
