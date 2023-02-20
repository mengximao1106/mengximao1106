package algorithm;

import java.util.*;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金，现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 *
 * 输入描述:
 *
 * 输入第一行为一维整型数组M，数组长度小于100，数组元素记录单个商品的价格，单个商品价格小于1000。
 * 输入第二行为购买资金的额度R，R小于100000。
 * 输出描述:
 *
 * 输出为满足上述条件的最大花费额度。
 * 注意：
 *
 * 如果不存在满足上述条件的商品，请返回-1。
 * 示例1
 *
 * 输入
 *
 * 23,26,36,27
 *
 * 78
 *
 * 输出
 *
 * 76
 *
 * 说明
 *
 * 金额23、26和27相加得到76，而且最接近且小于输入金额78
 *
 * 示例2
 *
 * 输入
 *
 * 23,30,40
 *
 * 26
 *
 * 输出
 *
 * -1
 */
public class Solution87 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           String[] s = scanner.nextLine().split(",");
           int[] arr = new int[s.length];
           for (int i = 0; i < arr.length; i++) {
               arr[i] = Integer.valueOf(s[i]);
           }
           int m = Integer.valueOf(scanner.nextLine());
           System.out.println(func(arr, m));
        }
    }

    private static int func(int[] arr, int m) {

        List<Integer> list = new ArrayList<>();
        List<Integer> moneyList = new ArrayList<>();
        int count = 3;
        back(arr, list, moneyList, 0, count);

        if (!moneyList.isEmpty()) {
            Collections.sort(moneyList, (o1, o2) -> o2 -o1);
            for (int i = 0; i < moneyList.size(); i++) {
                if (m > moneyList.get(i)) {
                    return moneyList.get(i);
                }
            }
        }

        return -1;
    }

    private static void back(int[] arr, List<Integer> list, List<Integer> moneyList, int index, int count) {
        if (index == count) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            moneyList.add(sum);
            return;
        }

        for (int a : arr) {
            if (!list.contains(a)){
                list.add(a);
                back(arr, list, moneyList, index + 1, count);
                list.remove(index);
            }
        }
    }

}
