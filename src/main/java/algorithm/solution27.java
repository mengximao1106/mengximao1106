package algorithm;

import java.util.*;

public class solution27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (!s.contains("0") || !s.contains("1")) {
            System.out.println("-1");
            System.exit(0);
        }
        String[] areas = s.split(",");

        int l = areas.length;
        int n = (int)Math.sqrt(l);
        int[][] sources = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sources[i][j] = Integer.valueOf(areas[i * n + j]);
            }
        }
//        for (int[] s1 : sources) {
//            System.out.println(Arrays.toString(s1));
//        }

        System.out.println(useDate(sources));

    }

    public static int useDate(int[][] sources) {
        int day = 0;
        while (!isCheck(sources)) {
            List<String> list = getInfectList(sources);
            sources = infect(sources, list);
            day++;
        }
        return day;
    }

    private static  List<String> getInfectList(int[][] sources) {
       List<String> list = new ArrayList<>();

        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                if (sources[i][j] == 1) {
                    list.add(i+","+j);
                }
            }
        }
        return list;
    }

    private static int[][] infect(int[][] sources,  List<String> list) {
        int[][] tmp = sources;
        int[][] t = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (String s : list) {
            int m = Integer.valueOf(s.split(",")[0]);
            int n =  Integer.valueOf(s.split(",")[1]);
            for (int k = 0; k < t.length; k++) {
                int x = m + t[k][0];
                int y = n + t[k][1];
                if (x >= 0 && y >= 0 && x < sources.length && y <sources.length) {
                    tmp[x][y] = 1;
                }
            }
        }

        return tmp;
    }

    private static boolean isCheck(int[][] sources) {
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                if (sources[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
