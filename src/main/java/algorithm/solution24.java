package algorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class solution24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String memoryPool = scanner.nextLine();
        String memorys = scanner.nextLine();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        String[] pool = memoryPool.split(",");
        for (String p : pool) {
            String[] m = p.split(":");
            map.put(Integer.valueOf(m[0]), Integer.valueOf(m[1]));
        }
        String[] ms = memorys.split(",");
        int[] mems = new int[ms.length];
        for (int i = 0; i < ms.length; i++) {
            mems[i] = Integer.valueOf(ms[i]);
        }
        System.out.println(Arrays.toString(memoryDistribution(map, mems)));
        scanner.close();
    }

    public static boolean[] memoryDistribution(TreeMap<Integer, Integer> map, int[] mems) {

        boolean[] res = new boolean[mems.length];
        for (int i = 0; i < mems.length; i++) {
            int mem = mems[i];
            res[i] = isCanDistri(map, mem) ? true : false;
        }

        return res;
    }

    private static boolean isCanDistri(TreeMap<Integer, Integer> map, int mem) {

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key >= mem && value > 0) {
                int newKey = key - mem;
                if (newKey != 0) {
                    if (map.containsKey(newKey)) {
                        map.put(newKey, map.get(newKey) + 1);
                    }else {
                        map.put(newKey, 1);
                    }
                }
                map.put(key, value -1);
                return true;
            }
        }
        return false;
    }
}
