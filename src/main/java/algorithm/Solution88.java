package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        char[] chars = line.toCharArray();
        ArrayList<Integer> int_shuang_ying_hao = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {
                int_shuang_ying_hao.add(i);
            }
        }

        if (int_shuang_ying_hao.size() == 0) {
            int_shuang_ying_hao.add(chars.length);
            int_shuang_ying_hao.add(chars.length + 1);
        }

        ArrayList<String> strings = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < int_shuang_ying_hao.size() - 1; i++) {
            int le = int_shuang_ying_hao.get(i);
            int ri = int_shuang_ying_hao.get(i + 1);

            StringBuilder sb = new StringBuilder();
            if (le > left) {
                for (int j = left; j < le; j++) {
                    if (chars[j] != '_') {
                        sb.append(chars[j]);
                    } else {
                        if (sb.length() != 0) {
                            strings.add(sb.toString());
                            sb.setLength(0);
                        }
                    }
                }
            }

            for (int j = le + 1; j < ri; j++) {
                sb.append(chars[j]);
            }
            strings.add(sb.toString());
            sb.setLength(0);

            if (i == int_shuang_ying_hao.size() - 2 && ri < chars.length - 1) {
                for (int j = ri + 1; j < chars.length; j++) {
                    if (chars[j] != '_') {
                        sb.append(chars[j]);
                    } else {
                        if (sb.length() != 0) {
                            strings.add(sb.toString());
                            sb.setLength(0);
                        }
                    }
                }
            }


            left = ri + 1;

            i++;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < strings.size(); i++) {
            if (i == 0) {
                sb.append(strings.get(i));
                continue;
            }
            if (i == K) {
                sb.append("_").append("******");
                flag = true;
                continue;
            }
            sb.append("_").append("".equals(strings.get(i)) ? "\"\"" : strings.get(i));
        }
        System.out.println(flag ? sb : "ERROR");
    }
}
