package algorithm;

import java.util.Scanner;

public class Solution51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            int ans = N, temp = 0, k = 0, j = 1;
            while (N > 0) {
                //先判断个位上是否跳了4，如果个位上是5~9，就先temp=1。
                if (N % 10 > 4) {
                    temp += j;
                } else {
                    temp += (N % 10) * k;
                }
                k = k * 9 + j;//k代表跳了多少次4，多收了多少个1元
                j *= 10;//j代表位数，1代表个位，10代表十位
                N /= 10;//相当于将N整体右移一位
            }
            System.out.println(ans - temp);
        }
    }
}
