package algorithm;

import java.util.Collections;
import java.util.regex.Pattern;

public class solution21 {

    public static void main(String[] args) {
        System.out.println(String.join("", Collections.nCopies(3, "abc")));
        System.out.println(compress("3[m20[c]]"));
    }

    //3[m2[c]]
    public static String compress(String s ) {
        String result = s;
        // n为数字的索引，x为[索引，y为]索引
        int n = -1, x = -1, y = -1;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (index + 1 != s.length()
                    && Pattern.matches("[a-z]", c + "" )
                    && Pattern.matches("\\d", s.charAt(index + 1) + "" )) {
                n = index;
            }

            if (c == '[') {
                x = index;
            }

            if (c == ']') {
                y = index;
                break;
            }
            index++;
        }

        if (x != -1) {
            String tmp = s.substring(x + 1, y);
            //处理m12这种2位数的count
            int cnt = Integer.valueOf(s.substring(n + 1, x));
            String compass = String.join("", Collections.nCopies(cnt, tmp));
            result = s.substring(0, n + 1) + compass + s.substring(y + 1);
            result = compress(result);
        }

        return result;
    }

}
