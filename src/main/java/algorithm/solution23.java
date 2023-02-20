package algorithm;

import java.util.*;

public class solution23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 存储同一个team
            List<Set<Integer>> teamList = new ArrayList<>();
            // 存储需要判断是否同一个团队的队友
            List<String> list = new ArrayList<>();
            int people = sc.nextInt();
            int number = sc.nextInt();
            for (int i = 0; i < number; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (c == 0) {
                    // 标识是否与前面的组是相同团队
                    boolean flag = false;
                    for (Set<Integer> set : teamList) {
                        if (set.contains(a) || set.contains(b)) {
                            set.add(a);
                            set.add(b);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        Set<Integer> set = new HashSet<>();
                        set.add(a);
                        set.add(b);
                        teamList.add(set);

                    }
                } else {
                    list.add(a + " " + b + " " + c);
                }
            }
            for (String s : list) {
                String[] split = s.split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                if (c != 1) {
                    System.out.println("da pian zi");
                } else {
                    boolean flag = false;
                    for (Set<Integer> set : teamList) {
                        if (set.contains(a) && set.contains(b)) {
                            System.out.println("we are a team");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("we are not a team");
                    }
                }
            }
        }
        sc.close();
    }

}
