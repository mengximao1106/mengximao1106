package algorithm;

public class Solution82 {
    /**
     * 0 -2 -7 0
     * 9 2 -6 2
     * -4 1 -4 1
     * -1 8 0 -2
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {{0, -2, -7, 0}, {9, 2, -6, 2}, {-4, 1, -4, 1}, {-1, 8, 0, -2}};
        System.out.println(subMaxMatrix(arr));
    }

    public static int subMaxMatrix(int[][] matrix) {

        int[][] total = matrix;
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                total[i][j] += total[i-1][j];
            }
        }

        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
                int[] result = new int[matrix[0].length];
                for (int f = 0; f < matrix[0].length; f++) {
                    if (i == 0) {
                        result[f] = total[j][f];
                    } else {
                        result[f] = total[j][f] - total[i - 1][f];
                    }
                }
                int maximal = maxSubsequence(result);

                if (maximal > maximum) {
                    maximum = maximal;
                }
            }
        }

        return maximum;
    }

    public static int maxSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxSub = new int[array.length];
        maxSub[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];
            if (max < maxSub[i]) {
                max = maxSub[i];
            }
        }
        return max;
    }
}
