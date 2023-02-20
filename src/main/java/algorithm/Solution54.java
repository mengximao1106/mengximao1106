package algorithm;

import java.util.Scanner;

public class Solution54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        System.out.println(minStep(arr));
    }
    
    public static int minStep(int[] arr) {
        int len = arr.length;
        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i < len / 2; i++) {
            int sum = 0;
            int count = 1;
            for (int j = i; j < len; j++) {
                sum += i + arr[j] + 1;
                count++;
                if (sum == len) {
                    minStep = Math.min(minStep, count);
                }
            }
        }
        return Math.min(minStep, len);
    }
}
