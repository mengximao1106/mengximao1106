package algorithm;

import java.util.*;

public class Solution64 {


    /**
     * 题目：
     * 某文件系统中有N个目录，每个目录都一个独一无二的ID。每个目录只有一个父目录，但每个父目录下可以有零个或者多个子目录，目录结构呈树状结构。
     * 假设，根目录的ID为0，且根目录没有父目录，其他所有目录的ID用唯一的正整数表示，并统一编号。
     * 现给定目录ID和其父目录ID的对应父子关系表[子目录ID，父目录ID]，以及一个待删除的目录ID，请计算并返回一个ID序列，表示因为删除指定目录后剩下的所有目录，返回的ID序列以递增序输出。
     * 注意：
     * 1、被删除的目录或文件编号一定在输入的ID序列中；
     * 2、当一个目录删除时，它所有的子目录都会被删除。
     *
     * 输入描述: 输入的第一行为父子关系表的长度m；接下来的m行为m个父子关系对；最后一行为待删除的ID。序列中的元素以空格分割，参见样例。
     *
     * 输出描述: 输出一个序列，表示因为删除指定目录后，剩余的目录ID。
     * 输入
     * 5
     * 8 6
     * 10 8
     * 6 0
     * 20 8
     * 2 6
     * 8
     *
     * 输出
     * 2 6
     *
     * 树的结构如下：
     *          6
     *        /   \
     *       2     8
     *            /  \
     *           10   20
     *
     * @param args
     */

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            String[] params = scanner.nextLine().split(" ");
            int root = Integer.valueOf(params[1]);
            int child = Integer.valueOf(params[0]);
            if (map.containsKey(root)) {
                List<Integer> childList = map.get(root);
                childList.add(child);
                map.put(root, childList);
            }else {
                List<Integer> childList = new ArrayList<>();
                childList.add(child);
                map.put(root, childList);
            }
        }
        int delNum = Integer.valueOf(scanner.nextLine());

        map.entrySet().forEach(e -> {
            List<Integer> value = e.getValue();
            Collections.sort(value);
            e.setValue(value);
        });

        System.out.println(map);
        delete(delNum);
        System.out.println(map);
        System.out.println(getRes());
    }

    private static StringBuilder getRes() {
        List<Integer> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (!res.contains(k) && k != 0) {
                res.add(k);
            }

            v.forEach(l -> {
                if (!res.contains(l) && l != 0) {
                    res.add(l);
                }
            });
        });

        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        res.forEach(l -> {
            sb.append(l);
            sb.append(" ");
        });
        return sb;
    }

    public static void delete(int delNum) {

        map.forEach((k, v) -> {
            if (v != null) {
                if (v.contains(delNum)) {
                    Iterator<Integer> it = v.iterator();
                    while (it.hasNext()){
                        int s = it.next();
                        if (s == delNum){
                            it.remove();
                        }
                    }
                }
            }
        });

        doDelete(delNum);
    }

    public static void doDelete(int delNum) {
        List<Integer> child = map.get(delNum);
        if (child == null) {
            return;
        }

        for (int i = 0; i < child.size(); i++) {
            delete(child.get(i));
        }

        map.remove(delNum);
    }

}
