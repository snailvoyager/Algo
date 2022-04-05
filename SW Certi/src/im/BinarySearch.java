package im;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        int x = 8;
        System.out.println(biSearch(arr, x));
        System.out.println(biSearchRecur(arr, x, 0, arr.length-1));
        System.out.println(Arrays.binarySearch(arr, x));
    }

    public static int biSearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else if (arr[mid] > x) {
                right = mid - 1;
            }
        }
        throw new NoSuchElementException();
    }

    public static int biSearchRecur(int[] arr, int x, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return biSearchRecur(arr, x, mid+1, right);
        } else {
            return biSearchRecur(arr, x, left, mid-1);
        }
    }
}
