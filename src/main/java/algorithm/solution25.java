package algorithm;

import java.util.Scanner;

public class solution25 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(recursion(k));
    }

    static int recursion(int k){
        //f（1）=1，即1=1；
        //f（2）=1，即2=1+1（注意：跳法中不允许直接跳2级）；
        //f（3）=2，即3=1+1+1，3=3；
        if(k == 1 || k == 2){
            return 1;
        }
        if(k == 3){
            return 2;
        }
        return recursion(k - 1) + recursion(k - 3);
    }
}
