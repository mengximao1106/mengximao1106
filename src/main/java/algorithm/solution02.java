package algorithm;

public class solution02 {

    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        int k = 25;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int res = -1;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += chalk[i];
        }
        k %= total;
        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
