package algorithm;

public class solution26 {

    /**
     * 0 0 0
     * 0 0 0
     * 0 0 0
     * @param args
     */
    public static void main(String[] args) {
        //前后左右
        int[][] tmp = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        // m[1][1]
        int[][] m = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        for (int i = 0; i < 4; i++) {
            int x = 1;
            int y = 1;
            x = x + tmp[i][0];
            y = y + tmp[i][1];
            m[x][y] = 1;
        }

        for (int[] x : m){
            for (int y : x) {
                System.out.println(y + "");
            }
        }

        /** 结果：
         * 0 1 0
         * 1 0 1
         * 0 1 0
         */

    }
}
