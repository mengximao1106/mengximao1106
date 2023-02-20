package algorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class solution50 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        String[] arr2 = new String[5];
        for (int j = 0; j < 5; j++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            arr[j] = trans2Int(s1[0]);
            arr2[j] = s1[1];
        }

        System.out.println(Arrays.toString(arr));

        System.out.println(func(arr, arr2));

    }

    public static int func(int[] arr1, String[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        Collections.sort(list);

        if (isContinuation(list) && isSame(arr2)) {
            return 1;
        }

        if (istiao(arr1, 4)) {
            return 2;
        }

        if (isHulu(arr1)) {
            return 3;
        }

        if (isTonghua(arr2)) {
            return 4;
        }

        if (isContinuation(list)) {
            return 5;
        }

        if (istiao(arr1, 3)) {
            return 6;
        }

        return 7;
    }

    private static boolean isTonghua(String[] arr2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                map.put(arr2[i], map.get(arr2[i]) + 1);
            }else {
                map.put(arr2[i], 1);
            }
        }
        AtomicBoolean flag = new AtomicBoolean(false);
        map.forEach((k, v) -> {
            if (v == 5) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    private static boolean isHulu(int[] arr1) {
        boolean f1 = false;
        boolean f2 = false;
        int[] repeats = new int[14];
        for (int i = 0; i < arr1.length; i++) {
            repeats[arr1[i]]++;
        }

        for (int i = 0; i < repeats.length; i++) {
            if (repeats[i] == 3) {
                f1 = true;
            }
            if (repeats[i] == 2) {
                f2 = true;
            }
        }


        return f1 && f2;
    }

    private static boolean istiao(int[] arr1, int k) {
        int[] repeats = new int[14];
        for (int i = 0; i < arr1.length; i++) {
            repeats[arr1[i]]++;
        }

        for (int i = 0; i < repeats.length; i++) {
            if (repeats[i] == k) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSame(String[] arr2) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set.size() == 1;
    }

    private static boolean isContinuation(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) != list.get(i + 1) - 1) {
                return false;
            }
        }
        return true;
    }

    public static int trans2Int(String s) {
        if (Character.isDigit(s.charAt(0))){
            return Integer.valueOf(s);
        }

        switch (s) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                throw new RuntimeException();
        }
    }
}
