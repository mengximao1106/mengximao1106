package algorithm;

import java.util.Scanner;

public class solution29 {

    public static void main(String[] args) {
        //[3,30,34,5,9]
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine()
                .replace("[", "")
                .replace("]", "")
                .split(",");

        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }

        System.out.println(func(arr));

    }

    public static String func(int[] nums) {
        int len =nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String s1 = "" + nums[i] + nums[j];
                String s2 =  "" + nums[j] + nums[i];
                if (Long.valueOf(s1) < Long.valueOf(s2)) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }
}
