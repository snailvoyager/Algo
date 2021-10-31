package programmers;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        //String[] arr = {"123","456","789"};
        //String[] arr = {"12","123","1235","567","88"};
        System.out.println(solution3(arr));
    }

    public static boolean solution(String[] phone_book) {       //시간 초과
        boolean answer = true;

        for (String s : phone_book) {
            for (String s2 : phone_book) {
                if (s.equals(s2) || s.length() < s2.length()){  //같거나 길이가 크면 패스
                    continue;
                }
                if (s.startsWith(s2)) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static boolean solution2(String[] phone_book) {      //run time error
        boolean answer = true;
        List<String> list = new LinkedList<String>();
        Collections.addAll(list, phone_book);
        //길이 내림차순 정렬
        Comparator<String> cp = (o1, o2) -> o1.length() < o2.length() ? 1 : -1;
        Collections.sort(list, cp);

        //해쉬에 문자열 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                return false;
            } else {
                for (int i=1; i<=s.length(); i++) {
                    map.put(s.substring(0, i), 1);
                }
            }
        }

        return answer;
    }

    public static boolean solution3(String[] phone_book) {      //run time error
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            if (map.containsKey(s)) {
                return false;
            } else {
                for (int i=1; i<=s.length(); i++) {
                    map.put(s.substring(0, i), 1);
                }
            }
        }
        return answer;
    }
}
