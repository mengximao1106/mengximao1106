package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class solution47 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 一、小朋友的个数
        int n = sc.nextInt();
        // 二、 各个小朋友的身高
        int [] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(heights));
        // 3 、定义数组存放小朋友好朋友的位置
        int[] positions = new int[n];
        // 四、每一个小朋友和以后的小朋友比身高，若是后面有小朋友身高比他高，一旦找到，就把好朋友的位置传到新数组，结束本次循环，
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ( heights[i] < heights[j]) {
                    positions[i] = j;
                    System.out.println("小朋友的身高为："+ heights[i]  +  "好朋友的身高为：" + heights[j] + "位置为：" + positions[i]);
                    break;
                } else {
                    positions[i] = 0;
                }
            }
        }
        positions[n-1] = 0;
        System.out.println( Arrays.toString( positions ) );
    }

}
