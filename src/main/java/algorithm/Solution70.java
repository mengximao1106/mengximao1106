package algorithm;

import java.util.*;

public class Solution70 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.valueOf(scanner.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextLine());
            }
            sortTime(list);
        }

    }

    private static void sortTime(List<String> list) {
        Collections.sort(list, Comparator.comparingInt(Solution70::parseTime));
        System.out.println("sorted : ");
        list.forEach(System.out::println);
    }

    // 23:41:08.023
    private static int parseTime(String v1) {
        String[] time = v1.split(":");
        String[] millisTime = time[2].split("\\.");
        String[] tmp = new String[time.length + millisTime.length - 1];
        tmp[0] = time[0];
        tmp[1] = time[1];
        tmp[2] = millisTime[0];
        tmp[3] = millisTime[1];
        int[] t = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            t[i] = Integer.valueOf(tmp[i]);
        }
        return t[0] * 60 * 60 * 1000 + t[1] * 60 * 1000 + t[2] * 1000 + t[3];
    }
}
