package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution20 {
    public static List solution(int n, int m) {
        List res = new ArrayList();
        for (int a = n; a <= m - 2; ++a) {
            for (int b = a + 1; b <= m - 1; ++b) {
                //求c
                double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
                long cz = (long) c;
                if (c - cz == 0 && c <= m && isPrim(a,b) && isPrim(a, (int) c) && isPrim(b, (int) c)) {
                    res.add(new int[]{a, b, (int) c});
                } else if (c > m) {
                    break;
                }
            }
        }

        return res;
    }

    //判断a,b,c互质
    public static boolean isPrim(int x, int y) {
        int min = Math.min(x, y);
        double sqrt = Math.sqrt(min);
        for (int i = 2; i < sqrt; i++) {
            if (x % i == 0 && y % i == 0) {
                return false;
            }
        }
        return true;
    }

    //判断a,b,c互质
    /*public static boolean isPrim(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        //辗转相除
        while((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;
    }*/


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long start = System.currentTimeMillis();
        List<int[]> res = solution(n, m);
        res.forEach(res1 -> {
            System.out.println(res1[0] + " " + res1[1] + " " + res1[2]);
        });
        long end = System.currentTimeMillis();
        System.out.println("use time : " + (end - start) + "ms");
    }
}
