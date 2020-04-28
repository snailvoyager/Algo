package LeetCode.Easy;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1010", "1011"));
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1", "1011"));
	}
	
	public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length()-1;
        int j = b.length()-1;
        int c = 0;
        
        while(i>=0 || j>=0){
            int aa =0, bb = 0;

        	if(i>=0) aa = a.charAt(i--) - '0';     // '1'-'0'=1, '0'-'0'=0
            if(j>=0) bb = b.charAt(j--) - '0';
            int sum = aa+bb+c;
            result.append(sum % 2);		//뒷자리부터 구하기
            c = sum / 2;				//보수 구하기
        }
        if(c > 0) result.append(c);		//남은 보수 붙이기
        
        return result.reverse().toString();
    }

}
