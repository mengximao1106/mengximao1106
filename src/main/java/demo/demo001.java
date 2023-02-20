package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo001 {
    /**
     * 3
     * 2
     * 1,2,3,4,5,6,7,8,9,2
     * 2,5,8,3,6
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.valueOf(scanner.nextLine());
        int n = Integer.valueOf(scanner.nextLine());
        List<String> list = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine().replace(",", "");
            list.add(s);
            maxLen = Math.max(maxLen, s.length());
        }
        int maxCount = maxLen / k == 0 ? maxLen / k : maxLen / k + 1;
        int count = 1;
        StringBuffer sb = new StringBuffer();
        while (count <= maxCount) {
            int curIndex = count * k;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                int l = s.length();
                if (l > curIndex) {
                    sb.append(s, (count-1) * k, curIndex);
                } else if ((count -1) * k <= l) {
                    sb.append(s, (count -1) * k, l);
                }
            }
            count++;
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            res.append(sb.charAt(i));
            res.append(",");
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}
