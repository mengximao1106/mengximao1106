package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Solution99 {

    //a:3,b:5,c:2@a:1,b:2
    //a:2,b:3,c:2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] all = s.split("@")[0].split(",");
        String[] use = s.split("@")[1].split(",");
        Map<String, Integer> allMap = new HashMap<>();
        Map<String, Integer> useMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < all.length; i++) {
            String key = all[i].split(":")[0];
            String val = all[i].split(":")[1];
            queue.offer(key);
            allMap.put(key, Integer.valueOf(val));
        }

        for (int i = 0; i < use.length; i++) {
            String key = use[i].split(":")[0];
            String val = use[i].split(":")[1];
            useMap.put(key, Integer.valueOf(val));
        }

        useMap.forEach((k1, v1) -> {
            if (allMap.containsKey(k1)) {
                allMap.put(k1, allMap.get(k1) - v1);
            }
        });

        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = allMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        while (!queue.isEmpty()) {
            String p = queue.poll();
            if (map.containsKey(p)) {
                sb.append(p);
                sb.append(":");
                sb.append(map.get(p));
                sb.append(",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
