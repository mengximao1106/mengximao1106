package algorithm;

import java.util.Scanner;

public class Solution92 {

    static int[] postArr;
    static int[] midArr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        postArr = new int[n+1];
        midArr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            postArr[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            midArr[i] = scan.nextInt();
        }

        Node root = f(1, n,1, n);

        System.out.print("Preorder:");
        preorder(root);
    }

    /**
     *
     * @param hStart 后续遍历数组下标
     * @param hEnd
     * @param midStart 中续遍历数组下标
     * @param midEnd
     * @return
     */
    static Node f(int hStart, int hEnd, int midStart, int midEnd){

        // 越界
        if (hStart > hEnd || midStart > midEnd) return null;

        Node root = new Node();
        root.data = postArr[hEnd];  // 后续遍历的根节点
        /**
         * 7
         * 2 3 1 5 7 6 4
         * 1 2 3 4 5 6 7
         */
        // 在中续遍历数组中查找当前子树的根节点
        for (int i = midStart; i <= midEnd; i++) {  // 注意是小于等于
            if (midArr[i] == postArr[hEnd]){

                // 对于后续遍历: (hStart ~ (hEnd-右子树长度-1)) + (hEnd-右子树长度 ~ hEnd-1) + hEnd
                // 对于中续遍历: (midstart ~ i-1) + (i) + (i+1 ~ midEnd)

                root.l = f(hStart, hEnd - (midEnd - i) - 1 ,midStart,i-1);
                root.r = f(hEnd - (midEnd - i),hEnd-1, i+1, midEnd);
                break;
            }
        }

        return root;
    }

    static void preorder(Node node){

        if(node==null) return;

        System.out.print(" " + node.data);

        preorder(node.l);
        preorder(node.r);
    }
}

class Node{

    Node r;
    Node l;
    int data;
}
