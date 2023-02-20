package algorithm;

import java.util.Stack;

public class solution09 {

    public static void main(String[] args) {
        String s = "7#6$5#12";
        System.out.println(result(s));
    }

    public static int result(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        String keepNum = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOper(c)) {
                if (charStack.isEmpty()) {
                    charStack.push(c);
                } else {
                    //当前运算符优先级比栈里的低，则取数字栈和字符栈运算，运算结果入数字栈，当前的字符栈入字符栈
                    if (priority(c) <= priority(charStack.peek())){
                        int y = numStack.pop();
                        int x = numStack.pop();
                        char opera = charStack.pop();
                        numStack.push(cal(x, y, opera));
                        charStack.push(c);
                    } else {//如果当前运算符比栈里的优先级高，则直接入栈
                        charStack.push(c);
                    }
                }
            } else {
                keepNum += c;
                if (i == s.length() - 1) {
                    numStack.push(Integer.valueOf(keepNum));
                } else {
                    if (i+2 < s.length() && isOper(s.substring(i+1, i+2).charAt(0))) {
                        numStack.push(Integer.valueOf(keepNum));
                        keepNum = "";
                    }
                }
            }
        }

        //7 95 12

        //12 95 7

        Stack<Integer> res = new Stack<>();
        while (!numStack.isEmpty()) {
            res.push(numStack.pop());
        }

        while (!charStack.isEmpty()) {
            int x = res.pop();
            int y = res.pop();
            char opera = charStack.pop();
            res.push(cal(x, y, opera));
        }

        return res.pop();
    }

    public static boolean isOper (char c) {
        return c == '#' || c == '$';
    }

    public static int priority(char c){
        if (c == '$') {
            return 2;
        }

        if (c == '#') {
            return 1;
        }
        return -1;
    }

    public static int cal(int x, int y, char opera){
        if (opera == '#') {
            return rule1(x, y);
        }
        if (opera == '$') {
            return rule2(x, y);
        }
        return -1;
    }

    //x#y = 2x+3y+4
    public static int rule1(int x, int y) {
        return 2 * x + 3 * y +4 ;
    }

    //x$y = 3*x+y+2
    public static int rule2(int x, int y) {
        return 3 * x + y + 2;
    }
}
