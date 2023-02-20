package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solution49 {

    public static void main(String[] args) {

        String s = "-1 -3 7 5 11 15";
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.valueOf(s1[i]);
        }
        //负数的最小值 + 正数的最小值肯定是绝对值的最小值

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                list1.add(arr[i]);
            }else {
                list2.add(arr[i]);
            }
        }

        if (list1.size() > 0) {
            Collections.sort(list1);
        }
        if (list2.size() > 0) {
            Collections.sort(list2);
        }
        if (list1.isEmpty()) {
            System.out.println(list2.get(0) + " " + list2.get(1) + " " + list2.get(0) + list2.get(1));
        }else {
            System.out.println(list1.get(0) + " " + list2.get(0) + " " + (list1.get(0) + list2.get(0)));
        }

    }
}
