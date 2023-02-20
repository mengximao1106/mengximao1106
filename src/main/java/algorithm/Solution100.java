package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution100 {

    static Map<Character,String> map = new HashMap<>();

    static {
        map.put('1', ",.");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");
    }
    //#96662444777744/4445554443/33664
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == '#') {
            s = s.substring(1);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int index = i;
                int count = 0;
                while (index + 1 < chars.length && chars[index + 1] == c) {
                    index++;
                    count++;
                }
                i += count;
                if (chars[i] == '/') {
                    continue;
                }
                String v = map.get(c);
                sb.append(v.charAt((count) % v.length()));
            }
        }else {
            sb.append(s.replace("/", ""));
        }

        System.out.println(sb);
    }

}
