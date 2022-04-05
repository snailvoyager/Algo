package LeetCode.Easy;

public class Sqrt {
    static int[] numArray = new int[65536];

    public static void main(String[] args) {
        System.out.println(46340 * 46340);
        System.out.println(46341 * 46341);
        System.out.println(mySqrt(2147395600));
        System.out.println(mySqrtNew(2147395600));
    }

    static public int mySqrt(int x) {
        if (x < 1)
            return 0;
        int result = 1;

        for (int i=1; i<x; i++) {
            if ((i*i) < 0 || (i*i) > x) {
                break;
            } else {
                result = i;
            }
        }
        return result;
    }

    static public int mySqrtNew(int x) {
        if (x < 1)
            return 0;

        int left = 1, right = x;

        while(left <= right) {
            int mid = left + (right - left) /2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return right;
    }
}
