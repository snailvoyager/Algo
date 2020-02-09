package LeetCode.Easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
		System.out.println(longestCommonPrefix(new String[] {"c","c","c"}));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		
		if(strs.length == 0)
			return "";
		
		for(int i=0; i<strs[0].length(); i++) {		//���ξ��� �ִ���̴� ����� �ּұ���
			char compare = strs[0].charAt(i);		//ù��° ��Ҹ� �������� ��
			for(int j=1; j<strs.length; j++) {		//�迭�� ��� ��
				if(strs[j].length() > i && compare == strs[j].charAt(i))	//���ϴ� ����� ���� ���̰� i��°���
					continue;
				else
					return sb.toString();
			}
			sb.append(compare);
		}
		
		return sb.toString();
	}

}
