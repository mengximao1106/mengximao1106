package algorithm;

import java.util.Scanner;

public class Solution55 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(",");
            if (s.length == 0) {
                System.out.println("/");
                return;
            }
            System.out.println(joinUrl(s[0], s[1]));
        }
    }

    public static String joinUrl(String s1, String s2) {
        String source = "/";
        String s1LastChar = s1.substring(s1.length() - 1);
        String s2FirstChar = s2.substring(0, 1);
        if (source.equals(s1LastChar) && source.equals(s2FirstChar)) {
            return s1 + s2.substring(1);
        }

        if (!source.equals(s1LastChar) && !source.equals(s2FirstChar)) {
            return s1 + source + s2;
        }

        if (source.equals(s1LastChar) && !source.equals(s2FirstChar)
                || !source.equals(s1LastChar) && source.equals(s2FirstChar)) {
            return s1 + s2;
        }
        return "/";
    }
}
