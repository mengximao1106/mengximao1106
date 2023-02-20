package algorithm;

import java.util.Scanner;

public class Solution72 {
    private static String[][] data = null;
    private static int[][] mark = null;
    private static String result = null;
    private static String work = null;
    private static int n;
    private static int m;

    private static int[][] tmp = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    /**
     * 5 5
     * SOLO
     * CPUCY
     * EKLQH
     * CRSOL
     * EKLQO
     * PGRBC
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            result="NO";
            n = sc.nextInt();
            m = sc.nextInt();
            work = sc.next();
            mark = new int[n][m];
            data = new String[n][m];
            for (int i = 0; i < n; i++) {
                // 这里直接将单词分开存入二位数组中
                data[i] = sc.next().split("");
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    find(i, j, 0);
                }
            }
            System.out.println(result);
        }
    }

    public static void find(int i, int j, int f) {
        if (i < 0 || i >= n || j < 0 || j >= m || f >= work.length()
                || mark[i][j] == 1 || !data[i][j].equals(String.valueOf(work.charAt(f)))) {
            return;
        }

        if (f == work.length() - 1 && String.valueOf(work.charAt(f)).equals(data[i][j])) {
            result = "YES";
            return;
        }
        mark[i][j] = 1;
        for (int k = 0; k < tmp.length; k++) {
            int x = i + tmp[k][0];
            int y = j + tmp[k][1];
            find(x, y, f + 1);
        }
    }

}
