package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class solution28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();

        System.out.println(func(s, k));
    }

    // AAAAHHHBBCDHHHH
    public static int func(String s, int k) {

        char[] chars = s.toCharArray();

        Map<String, Integer> map = new HashMap<>();
        int tmpChar = chars[0];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (tmpChar == curChar) {
                count++;
            }else {
                tmpChar = curChar;
                count = 1;
            }

            if (map.containsKey(curChar + "")) {
                map.put(curChar + "", Math.max(count, map.get(curChar + "")));
            }else {
                map.put(curChar + "", count);
            }
        }

        return map.entrySet().stream()
                .sorted((o1,o2) -> o2.getValue() -o1.getValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()).get(k - 1);

    }

}
