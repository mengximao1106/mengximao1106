package algorithm;

import java.util.*;

/**
 * 磁盘的容量单位常用的有M，G，T这三个等级，关系为 1T = 1024G、1G = 1024M，如样例所示先输入磁盘的个数，再依次输入磁盘的容量大小，然后按照从小到大的顺序对磁盘容量进行排序并输出。
 *
 * 样例：
 * 输入：
 * 3
 * 1G
 * 2G
 * 1024M
 * 输出：(容量相等，保留原来的相对位置)
 * 1G
 * 1024M
 * 2G
 *
 * 输入：
 * 5
 * 1T
 * 20M
 * 3G
 * 10G6T
 * 3M12G9M
 *
 * 输出：
 * 20M
 * 3G
 * 3M12G9M
 * 1T
 * 10G6T
 *
 */
public class Solution85 {
    static String M = "+";
    static String G = "*1024M";
    static String T = "*1024*1024M";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        sortMemory(list);
    }

    private static void sortMemory(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        list.forEach(l -> map.put(l, trans2Count(l)));
        map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey).forEach(System.out::println);
    }

    // 3M12G9M ==> 3M+12*1024M+9M ==> 3+12*1024+9+
    // 10G6T ==> 10*1024M6*1024*1024M ==> 10*1024*1+6*1024*1024*1+
    private static Integer trans2Count(String s) {
        //3*1+12*1024*1+9*1+
        String s1 = s.replace("T", T).replace("G", G).replace("M", M);
        String[] s2 = s1.split("\\+");
        int sum = 0;
        for (int i = 0; i < s2.length; i++) {
            if (s2[i] == "") {
                continue;
            }
            String[] s3 = s2[i].split("\\*");
            int sum1 = 1;
            for (int j = 0; j < s3.length; j++) {
                sum1 *= Integer.valueOf(s3[j]);
            }
            sum += sum1;
        }
        return sum;
    }


}
