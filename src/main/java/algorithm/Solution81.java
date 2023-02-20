package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution81 {
    /**
     * 3 5 7 -1 -1 2 4
     * 3 7 2
     *
     * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
     * 5 8 7 6
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        String[] str = in.nextLine().split(" ");
        in.close();
        for (String s : str) {
            res.add(Integer.parseInt(s));
        }
        int idx = dfs(res, 0);  // 找到叶子节点的索引
        List<Integer> arr = new ArrayList<>();  //存储根节点到最小叶子节点路径上的所有节点
        while (idx > 0) {  // 找到最小叶子节点的所有父节点的索引
            arr.add(res.get(idx));
            idx = (idx - 1) / 2;
        }
        arr.add(res.get(0));  // 加入根节点
        Collections.reverse(arr);  // 反转list
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + " ");
            }
        }
    }
    private static int dfs(List<Integer> res, int idx) {  // 返回最小叶子节点对应索引
        if (isLeaf(res, idx)) {
            return idx;
        } else {
            int idx_left = dfs(res, 2 * idx + 1);  // 递归左叶子节点
            int idx_right = dfs(res, 2 * idx + 2); // 递归右叶子节点
            if (idx_left >= res.size() || res.get(idx_left) == -1) {  // 只有右叶子节点
                return idx_right;
            } else if (idx_right >= res.size() || res.get(idx_right) == -1) {  // 只有左叶子节点
                return idx_left;
            } else {  // 左右叶子节点都有，找最小的
                return res.get(idx_left) < res.get(idx_right) ? idx_left : idx_right;
            }
        }
    }
    private static boolean isLeaf(List<Integer> res, int idx) {  // 判断是否是叶子节点
        return (2 * idx + 1 >= res.size() || res.get(2 * idx + 1) == -1)
                && (2 * idx + 2 >= res.size() || res.get(2 * idx + 2) == -1);
    }
}
