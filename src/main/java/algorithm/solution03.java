package algorithm;

public class solution03 {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        System.out.println("idx = " + idx);
        String w = word.substring(0, idx +1);
        System.out.println("w = " + w);
        String w2 = word.substring(idx + 1, word.length());
        StringBuilder sb = new StringBuilder(w);
        return sb.reverse() + w2;
    }
}
