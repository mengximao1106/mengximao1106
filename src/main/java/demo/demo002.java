package demo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class demo002 {
/*
5 7
2 1
1 4
2 4
2 3
3 4
3 5
5 2
2
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[m][2];

            for (int i = 0; i < m ; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            Set<String> all = new HashSet<>();
            all.add(k + "");
            int count = 0;
            while (true) {
                Set<String> child = new HashSet<>();
                for (int i = 0; i < arr.length; i++) {
                    if (all.contains(arr[i][0] + "") && !all.contains(arr[i][1] + "")) {
                        child.add(arr[i][1] + "");
                    }
                }
                all.addAll(child);
                if (!child.isEmpty()) {
                    count++;
                }else {
                    break;
                }
            }

            System.out.println(2 * count);
        }
    }
}
