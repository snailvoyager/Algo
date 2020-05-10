package im;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ITNE2_IPV4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ipclass = "123.23.256.255".split("\\.", -1);
		
		
		System.out.println(ipclass.length);
		for(int i=0; i<ipclass.length; i++) {
			int n = Integer.parseInt(ipclass[i]);
			System.out.println(n);
			if(n<0 || n>255)
				System.out.println("fail");
		}
		
		StringTokenizer st = new StringTokenizer("123.023..123.");
		String ipclass1 = st.nextToken(".");
		String ipclass2 = st.nextToken(".");
		String ipclass3 = st.nextToken(".");
		
		System.out.println(Arrays.toString(ipclass));
		System.out.println(ipclass1);
		System.out.println(ipclass2);
		System.out.println(ipclass3);
		
		
	}
	
	class Solution {
	    public int[] solution(String[] ip_addresses, String[] registered_list, String[] banned_list) {
	        int[] answer = new int[ip_addresses.length];
	        
	        loop1:
	        for(int i=0; i<ip_addresses.length; i++){
	            //규격검사
	            String[] ipclass = ip_addresses[i].split("\\.", -1);
	            if(ipclass.length != 4){
	                answer[i] = 1;
	                continue;
	            }
	            for(int j=0; j<4; j++){
	                if(ipclass[j].equals("")){
	                    answer[i] = 1;
	                    continue loop1;
	                }
	                if(ipclass[j].length() > 1){
	                    if(ipclass[j].charAt(0) == '0'){
	                        answer[i] = 1;
	                        continue loop1;
	                    }
	                }
	                int n = Integer.parseInt(ipclass[j]);
	                if(n<0 || n>255){
	                    answer[i] = 1;
	                    continue loop1;
	                }
	            }
	            //등록확인
	            for(int j=0; j<registered_list.length; j++){
	                if(ip_addresses[i].equals(registered_list[j])){
	                    answer[i] = 0;
	                    continue loop1;
	                }
	            }
	            //차단확인
	            for(int j=0; j<banned_list.length; j++){
	                if(ip_addresses[i].equals(banned_list[j])){
	                    answer[i] = 3;
	                    continue loop1;
	                }
	            }
	            answer[i] = 2;
	        }
	        
	        return answer;
	    }
	}

}
