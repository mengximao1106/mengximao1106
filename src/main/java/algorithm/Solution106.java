package algorithm;

import java.util.Scanner;

public class Solution106 {
    static int minCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();

        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(minCount);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int low, int height) {
        int i, j, temp, t;

        if (low > height) {
            return;
        }

        i = low;
        j = height;
        temp = arr[low];

        while (i < j) {
            while (i < j && temp <= arr[j]) {
                j--;
            }

            while (i < j && temp >= arr[i]) {
                i++;
            }

            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                minCount++;
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, height);

    }
}
