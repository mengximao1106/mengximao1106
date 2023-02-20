package algorithm;

import java.util.Scanner;

public class Solution86 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();

            System.out.println(func(s));
        }

    }

    private static String func(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int t = i;
                String num = c + "";
                int count = 0;
                while(Character.isDigit(chars[t + 1]) && t + 1 < chars.length) {
                    num += chars[t+1];
                    t++;
                    count++;
                }
                i += count;
                for (int j = 0; j < Integer.valueOf(num); j++) {
                    sb.append(chars[i+1]);
                }
                i++;
            }else {
                sb.append(chars[i]);
            }

        }

        return sb.toString();
    }


}
