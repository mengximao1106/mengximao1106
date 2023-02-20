package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class solution08 {

    public static void main(String[] args) {

        int[] hs = {95, 96 ,97, 98, 99, 101, 102, 103, 104, 105};

        sortedHeight(100, 10, hs);
    }


    public static void sortedHeight(int height, int count, int[] hs) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            int t = Math.abs(height - hs[i]);
            if (!map.containsKey(t)) {
                List<Integer> list = new ArrayList<>();
                list.add(hs[i]);
                map.put(t, list);
            } else {
                map.get(t).add(hs[i]);
            }

        }
        List<Integer> res = new LinkedList<>();
        map.forEach((k, v) -> {
            List<Integer> list = v.stream().sorted().collect(Collectors.toList());
            list.forEach(l -> res.add(l));
        });

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

