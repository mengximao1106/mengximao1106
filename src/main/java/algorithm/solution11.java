package algorithm;

import java.util.Stack;

public class solution11 {


    public static void main(String[] args) {
        System.out.println(appointStrLength(0,"asdbuiodevauufgh"));
    }

    //asdbuiodevauufgh
    public static int appointStrLength(int d, String s) {
        String source = "aeiouAEIOU";
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!source.contains(s.charAt(j) + "")) {
                continue;
            }
            int count = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = j; i < s.length(); i++) {
                stack.push(s.charAt(i));
                if (!source.contains(s.charAt(i) + "")) {
                    count++;
                    if (count > d) {
                        stack.clear();
                        break;
                    }
                }
                if (!stack.isEmpty() && source.contains(stack.peek() + "") && count == d ) {
                    max = Math.max(max, stack.size());
                }
            }
        }

        return max;
    }
}
