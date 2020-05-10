package im;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ITNE1_WorkingDay {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat format2 = new SimpleDateFormat("MM/dd");
		
		//System.out.println("2019/12/01 SUN".substring(0,10));
		
		Calendar start = Calendar.getInstance();
		start.setTime(format.parse("2000/02/01"));
		
		Calendar end = Calendar.getInstance();
		end.setTime(format.parse("2000/02/29"));
		
		String holi = "02/04";
		
		int workingday = 0;
		loop1:
		while(!start.after(end)) {
			String MMdd = format2.format(start.getTime());
			
			if(MMdd.equals(holi)) {
				start.add(Calendar.DATE, 1);
				continue loop1;
			}
			
			int day = start.get(Calendar.DAY_OF_WEEK);	//1~7
			
			//System.out.println(MMdd + " " + day);
			
			if(day != Calendar.SATURDAY && day != Calendar.SUNDAY) {	//주말 체크
				workingday++;
			}
			start.add(Calendar.DATE, 1);		//1일 증가
		}
		
		System.out.println(workingday);
	}
	
	class Solution {
	    public int solution(String join_date, String resign_date, String[] holidays) throws ParseException{
	        int answer = 0;
	        join_date = join_date.substring(0, 10);     //날짜추출
	        
	        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			SimpleDateFormat format2 = new SimpleDateFormat("MM/dd");
	        
	        Calendar start = Calendar.getInstance();
	        start.setTime(format.parse(join_date));
	        
	        Calendar end = Calendar.getInstance();
	        end.setTime(format.parse(resign_date));
	        
	        loop1:
	        while(!start.after(end)){
	            //공휴일 확인
	            String MMdd = format2.format(start.getTime());
	            for(int i=0; i<holidays.length; i++){
	                if(holidays[i].equals(MMdd)){
	                    start.add(Calendar.DATE, 1);
	                    continue loop1;
	                }
	            }
	            int day = start.get(Calendar.DAY_OF_WEEK);	//1~7
	            if(day != Calendar.SATURDAY && day != Calendar.SUNDAY) {	//주말 체크
					answer++;
				}
	            start.add(Calendar.DATE, 1);		//1일 증가
	        }
	        
	        return answer;
	    }
	}

}
