package algorithm;

import java.util.*;

public class solution07 {

    public static void main(String[] args) {
        // 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites = {{1, 0}};
        System.out.println(Arrays.toString(findOrder(2, prerequisites)));
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int num = 0;
        int count = 0;
        List<List<Integer>> pList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            pList.add(new ArrayList<>());
        }
        int[] degrees = new int[numCourses];
        for (int[] p : prerequisites) {
            pList.get(p[1]).add(p[0]);
            ++degrees[p[0]];
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                res[num++] = i;
            }
        }

        while (!queue.isEmpty()) {
            count++;
            int poll = queue.poll();
            for (Integer i : pList.get(poll)) {
                --degrees[i];
                if (degrees[i] == 0) {
                    queue.add(i);
                    res[num++] = i;
                }
            }
        }

        return count == numCourses ? res : new int[]{};
    }
}
