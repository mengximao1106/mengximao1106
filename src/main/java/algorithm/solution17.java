package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class solution17 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveRepeat(new int[]{1,3,3,3,2,4,4,4,5})));
    }

    public static int[] moveRepeat(int[] arr) {
        //数组索引代表重复次数，队列代表重复次数的元素
        Queue<Integer>[] queues = new Queue[100];
        Arrays.fill(queues, new ArrayDeque<>());
        Set<Integer> set = new LinkedHashSet<>();
        //数组索引代表元素，值代表重复次数
        int[] numRepeats = new int[100];
        for (int i = 0; i < arr.length; i++) {
            ++numRepeats[arr[i]];
            set.add(arr[i]);
        }

        for (int s : set) {
            queues[numRepeats[s]].offer(s);
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (int i = queues.length -1; i > 0; i--) {
            Queue<Integer> queue = queues[i];
            while(!queue.isEmpty()) {
                res[k] = queue.poll();
                k++;
            }
        }
        return res;
    }
}
