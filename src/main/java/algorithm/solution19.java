package algorithm;

public class solution19 {

    public static void main(String[] args) {

        System.out.println(findMinNumber("2615371", 4));
    }

    public static int findMinNumber(String num, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < num.length(); j++) {
                if (j == num.length() -1) {
                    num = num.substring(0, j);
                    break;
                }
                char c = num.charAt(j);
                if ( c - '0' <= num.charAt(j + 1) - '0') {
                    continue;
                } else {
                    num = num.substring(0, j) + num.substring(j + 1);
                    break;
                }
            }
        }

        return Integer.valueOf(num);
    }
}
