package algorithm;

import java.util.Scanner;

public class Solution30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(ans(n));
        }
    }

    private static int ans(int n) {
        int tmp = 0, j = 1, k = 0, ans = n;
        while (n > 0) {
            if (n % 10 > 4) {
                tmp = 1;
            }else {
                // 多少个 j * 10 + 2位数之后的另外的9
                tmp += (n % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            n /= 10;
        }
        return ans - tmp;
    }


}
