package algorithm;

import java.util.Scanner;

public class Solution68 {
    /**
     * 【区间交集】给定一组闭区间，其中部分区间存在交集。任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为
     * [3,5])。公共区间之间 若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。按升序排列 输出合并后的区间列表。
     * 输入描述: 一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
     * 输出描述: 升序排列的合并区间列表
     * 备注:
     * 1、区间元素均为数字，不考虑字母、符号等异常输入。
     * 2、单个区间认定为无公共区间。
     * 示例:
     * 输入
     * [[0, 3], [1, 3], [3, 5], [3, 6]]
     * 输出
     * [[1, 5]]
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(intersect(scanner.nextLine()));
    }


    public static String intersect(String s) {


        return "";
    }
}
