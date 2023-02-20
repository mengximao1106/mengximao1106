package algorithm;

import java.util.Scanner;

public class Solution98 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.valueOf(scanner.nextLine());
            String str = scanner.nextLine();

            if (str.charAt(0) == '_') {
                str = str.substring(1);
            }

            if (str.charAt(str.length() - 1) == '_') {
                str = str.substring(0, str.length() - 1);
            }
            int count = 0;
            int index = -1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '"' ) {
                    count++;
                    int t = i;
                    while (t + 1 < str.length() && str.charAt(t + 1) != '"') {
                        t++;
                    }
                    i = t + 1;
                    continue;
                }

                if (str.charAt(i) == '_') {
                    count++;
                }

                if (count == n + 1) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("ERROR");
                return ;
            }

            index++;

            if (str.charAt(index) == '"') {
                int t = index;
                while (t + 1 < str.length() && str.charAt(t + 1) != '"') {
                    t++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str, 0, index);
                sb.append("******");
                sb.append(str, t + 2, str.length());
                System.out.println(sb);
            }else {
                int t = index;
                while (t + 1 < str.length() && str.charAt(t + 1) != '_') {
                    t++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str, 0, index);
                sb.append("******");
                sb.append(str, t + 1, str.length());
                System.out.println(sb);
            }
        }

    }
}
