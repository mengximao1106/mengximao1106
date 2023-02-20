package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution101 {

    // f(n,m) = (f{n-1, m} + m) % n
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> list = new LinkedList<>();
        int person = 100;
        for (int i = 1; i <= person; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() >= m) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        System.out.println(list);


//        System.out.println(findTheWinner(100, 3));

    }

    public static int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;

    }
}