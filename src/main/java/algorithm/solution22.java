package algorithm;

import java.util.HashSet;
import java.util.Set;

public class solution22 {

    public static void main(String[] args) {
        System.out.println(shuixianhua("f3@d5a8"));
    }

    public static int shuixianhua(String s) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int sum = 0;
            char c = s.charAt(i);
            sum += c;
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                sum += c2;
                if (!isSxh(sum)) {
                    continue;
                }else {
                    if (res.contains(sum)) {
                        return -1;
                    }
                    res.add(sum);
                }
            }
        }

        return res.size();
    }

    private static boolean isSxh(int sum) {
        String s = sum + "";
        int count = s.length();
        int total = 0;
        for (int i = 0; i < count; i++) {
            String t = s.substring(i, i + 1);
            int num = Integer.valueOf(t);
            total += num * num * num;
        }
        return total == sum;
    }
}
