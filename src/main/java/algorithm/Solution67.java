package algorithm;

import java.util.Scanner;

public class Solution67 {
    /**
     * 【求解连续数列】已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
     * 输⼊描述：
     *
     * 输⼊包含两个参数，1）连续正整数数列和S，2）数列⾥数的个数N。
     *
     * 输出描述：
     *
     * 如果有解输出数列K，如果⽆解输出-1
     *
     * 示例1：
     * 输⼊
     *
     * 525 6
     *
     * 输出：
     *
     * 85 86 87 88 89 90
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int count = scanner.nextInt();

        System.out.println(output(total, count));
    }

    private static String output(int total, int count) {
        int avg = total / count;
        int halfCount = count % 2 == 0 ? count / 2 : count / 2 + 1;
        int start = avg - halfCount;
        int end = avg + halfCount;
        int realStrat = -1;
        for (int j = start; j <= end; j++) {
            if (((2 * j + count - 1) * count / 2) == total) {
                realStrat = j;
                break;
            }
        }
        if (realStrat == -1) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(realStrat);
            sb.append(" ");
            realStrat++;
        }
        return sb.toString();
    }
}
