package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小数字
 * 题目描述：
 * 给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。
 *
 * 输入描述：
 * 一行用半角逗号分割的字符串记录的整型数组，0 < 数组长度 <= 100，0 < 整数的取值范围 <= 10000。
 *
 * 输出描述：
 * 由3个元素组成的最小数字，如果数组长度小于3，则选择数组中所有元素来组成最小数字。
 *
 * 示例 1：
 * 输入
 * 21,30,62,5,31
 * 1
 * 输出
 * 21305
 * 1
 * 说明
 * 数组长度超过3，需要选3个元素组成最小数字，21305由21,30,5三个元素组成的数字，为所有组合中最小的数字
 *
 * 示例 2：
 * 输入
 * 5,21
 * 1
 * 输出
 * 215
 * 1
 * 说明
 * 数组长度小于3，选择所有元素组成最小值，215为最小值
 *
 */
public class Solution73 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        int[] intArr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            intArr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(intArr);
        int[] newArr = Arrays.copyOf(intArr, 3);
        String[] strArr  = new String[newArr.length];
        for (int i = 0; i < newArr.length; i++) {
            strArr[i] = String.valueOf(newArr[i]);
        }
        Arrays.sort(strArr, (s1, s2) -> {
            String o1 = s1 + s2;
            String o2 = s2 + s1;
            return o1.compareTo(o2);
        });
        System.out.println(Arrays.toString(strArr));
    }

}
