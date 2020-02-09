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
		
		for(int i=0; i<strs[0].length(); i++) {		//접두어의 최대길이는 요소의 최소길이
			char compare = strs[0].charAt(i);		//첫번째 요소를 기준으로 비교
			for(int j=1; j<strs.length; j++) {		//배열의 요소 비교
				if(strs[j].length() > i && compare == strs[j].charAt(i))	//비교하는 요소의 문자 길이가 i번째라면
					continue;
				else
					return sb.toString();
			}
			sb.append(compare);
		}
		
		return sb.toString();
	}

}
