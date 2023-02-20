package algorithm;

import java.util.Stack;

public class solution12 {

    public static void main(String[] args) {
        System.out.println(removeStr("abbssanvs"));
    }

    public static int removeStr(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.size();
    }



}
