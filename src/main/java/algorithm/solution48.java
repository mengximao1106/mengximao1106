package algorithm;

import java.util.*;

public class solution48 {

    public static void main(String[] args) {
        String s = "xyxyXX";
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o2.getKey() - o1.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getKey());
            sb.append(":");
            sb.append(list.get(i).getValue());
            sb.append(";");
        }

        String str = sb.substring(0, sb.length() -1);
        System.out.println(str);

        System.out.println("x = "+ Integer.valueOf('x'));
        System.out.println("y = "+ Integer.valueOf('y'));
        System.out.println("X = "+ Integer.valueOf('X'));
    }
}
