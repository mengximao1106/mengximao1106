package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class solution05 {

    public static void main(String[] args) {
        int[][] prerequisites = new int[2][2];
        prerequisites[0] = new int[]{0,1};
        prerequisites[1] = new int[]{1,2};
        System.out.println(canFinish(3, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preList = new ArrayList<>();
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preList.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            preList.get(p[1]).add(p[0]);
            ++degrees[p[0]];
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            ++cnt;
            int t = queue.poll();
            for (int d : preList.get(t)) {
                --degrees[d];
                if (degrees[d] == 0) {
                    queue.add(d);
                }
            }
        }

        return numCourses == cnt;
    }
}
