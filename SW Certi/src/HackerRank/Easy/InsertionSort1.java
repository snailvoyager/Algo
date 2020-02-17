package HackerRank.Easy;

import java.util.Scanner;

public class InsertionSort1 {

	static void insertionSort1(int n, int[] arr) {
        int end = arr[n-1];
        int i = 0;
        for(i=n-2; i>-1; i--){
            if(end < arr[i]){
                arr[i+1] = arr[i];
                for(int j : arr)
                System.out.print(j + " ");
                System.out.println();
            } else{
                break;
            }
            
        }
        arr[i+1] = end;
        for(int j : arr)
            System.out.print(j + " ");
        System.out.println();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }

}
