package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }
        System.out.println(list);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = list.get(i);
            String[] ss = s.split(",");
            for (int j = 0; j < ss.length; j++) {
                arr[i][j] = Integer.valueOf(ss[j]);
            }
        }
        System.out.println(maxSum(arr));
    }


    public static int maxSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += getMax(arr[i]);
        }
        return sum;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            int[] a = getChangeArr(arr, j);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(a[i]);
            }
            max = Math.max(Integer.parseInt(sb.toString(), 2), max);
        }
        return max;
    }

    private static int[] getChangeArr(int[] arr, int offset) {
        int[] cArr = new int[arr.length];
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = arr[(i + offset) % arr.length];
        }
        System.out.println(Arrays.toString(cArr));
        return cArr;
    }
}
