class Solution {
    static List<List<String>> result;
    public static List<List<String>> partition(String s) {
        result = new LinkedList<List<String>>();

        partitioning(s, null, 0);

        return result;
    }

    public static void partitioning(String sub, List<String> list, int idx) {
        if (list == null) {
            list = new LinkedList<String>();
        }
        if ("".equals(sub)) {
            //System.out.println(list);
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i=1; i<=sub.length(); i++) {
            String head = sub.substring(0, i);

            if (isPalindrome(head)) {
                list.add(head);
                partitioning(sub.substring(i), list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}