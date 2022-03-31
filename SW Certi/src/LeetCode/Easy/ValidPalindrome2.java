package LeetCode.Easy;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome3("abcda"));
        //System.out.println("abcd".substring(3,4));
    }
    public static boolean validPalindrome(String s) {
        if (s.length() == 1)
            return true;

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(1, s.length()));
//        System.out.println(sb.toString());
        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        }

        for (int i=1; i<s.length(); i++) {
            sb = new StringBuilder();

            sb.append(s.substring(0, i));
            sb.append(s.substring(i+1, s.length()));

//            System.out.println(sb.toString());
            if (sb.toString().equals(sb.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean validPalindrome2(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i=0; i<s.length(); i++) {
            int j;
            for (j=0; j<s.length()/2; j++) {
                int front = 0, rear = s.length() - 1;
                front += j;
                rear -= j;

                if (i <= front) {
                    front += 1;
                }
                if (i >= rear) {
                    rear -= 1;
                }

                if (s.charAt(front) != s.charAt(rear)) {
                    break;
                }
            }
            if (j >= s.length()/2) {
                return true;
            }
        }

        return false;
    }

    public static boolean validPalindrome3(String s) {
        int f = 0, r = s.length()-1;
        while (f <= r) {
            if (s.charAt(f) != s.charAt(r)) {
                return isPalindrome(s, f+1, r) || isPalindrome(s, f, r-1);
            }
            f++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int f, int r) {
        while (f <=r ) {
            if (s.charAt(f) != s.charAt(r)) {
                return false;
            }
            f++;
            r--;
        }

        return true;
    }
}
