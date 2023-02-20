package algorithm;

public class solution10 {


    public static void main(String[] args) {

        String s = "tryhard";
        System.out.println(maxVowels(s, 3));
    }


    public static int maxVowels(String s, int k) {
        int l = s.length();
        int max = Integer.MIN_VALUE;
        int count = 0 ;
        for (int i = 0; i < k; i++) {
            count += countStr(s.charAt(i));
        }

        for (int i = k; i < l; i++) {
            count += countStr(s.charAt(i)) - countStr(s.charAt(i-k));
            max = Math.max(count, max);
        }
        return count;
    }

    private static int countStr(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||c == 'o' || c == 'u' ? 1 : 0;
    }

}
