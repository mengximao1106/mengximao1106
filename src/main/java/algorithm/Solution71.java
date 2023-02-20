package algorithm;

import java.util.Scanner;

public class Solution71 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String[] m = scanner.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.valueOf(m[i]);
        }
        int k = Integer.valueOf(scanner.nextLine());

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }

        for (int j = k; j < arr.length; j++) {
            max = Math.max(max, max + arr[j]- arr[j-k]);
        }
        System.out.println(max);
    }

}
