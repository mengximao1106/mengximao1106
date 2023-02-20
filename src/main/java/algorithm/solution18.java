package algorithm;

import java.util.Scanner;

public class solution18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //warning :leak: 'sc' is never closed
        String s = sc.nextLine();   //输入的整型数;
        int n = sc.nextInt();
        int index;
        sc.close();
        if ( n > s.length()) {
            System.out.println("Error!");
            return;
        }
        for(int i = 0; i < n; i++) {
            int j = 0;        //j重新从0下标开始；
            while (j < s.length()) {
                if (j == s.length() - 1) {
                    s = s.substring(0, j);
                    break;
                }
                index = j + 1;
                char c = s.charAt(index);
                if (s.charAt(j) - '0' <= (c - '0')) {
                    j++;
                    continue;
                } else {
                    s = s.substring(0,j) + s.substring(index);      //把j位的字符截去；
                    break;
                }
            }
        }
        System.out.println(s);
    }
}
