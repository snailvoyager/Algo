package HackerRank.Easy;

import java.util.Scanner;

public class InsertionSort2 {

	static void insertionSort2(int n, int[] arr) {
        int j = 0;
        
        for(int i=1; i<n; i++){
            int comp = arr[i];
            for(j=i-1; j>-1; j--){
                if(comp < arr[j]){
                    arr[j+1] = arr[j];
                } else
                    break;
            }
            arr[j+1] = comp;
            
            for(int k : arr)
                System.out.print(k + " ");
            System.out.println();
        }

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

        insertionSort2(n, arr);

        scanner.close();
    }

}
