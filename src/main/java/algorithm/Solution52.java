package algorithm;

import java.util.*;

public class Solution52 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            int a = scanner.nextInt();
            String[] arr = s1.split(",");
            System.out.println(output(arr, a));
        }
    }

    private static String output(String[] arr, int a) {
        StringBuilder res = new StringBuilder();
        List<Integer> oriList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String c = arr[i];
            if (!c.contains("-")) {
                oriList.add(Integer.valueOf(c));
            }else {
                String[] t = c.split("-");
                int start = Integer.valueOf(t[0]);
                int end = Integer.valueOf(t[1]);
                while (start <= end) {
                    oriList.add(start);
                    start++;
                }
            }
        }

        Iterator<Integer> it = oriList.iterator();
        while (it.hasNext()){
            int s = it.next();
            if (s == a){
                it.remove();
            }
        }
        Collections.sort(oriList);
        //拼装res
        for (int i = 0; i < oriList.size(); i++) {
            int s = Integer.valueOf(oriList.get(i));
            if (i + 1 == oriList.size()) {
                res.append(oriList.get(i));
                break;
            }
            int t = i;
            while (oriList.get(t) + 1 == Integer.valueOf(oriList.get(t + 1))) {
                i++;
                t++;
            }
            int s2 = Integer.valueOf(oriList.get(i));
            if (s != s2) {
                res.append(s);
                res.append("-");
                res.append(s2);
                res.append(",");
            }else {
                res.append(s);
                res.append(",");
            }
        }

        return res.toString();
    }

}
