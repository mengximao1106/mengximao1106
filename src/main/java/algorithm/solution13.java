package algorithm;

public class solution13 {

    public static void main(String[] args) {
        System.out.println(subSequence("abc", "cjjbsyc"));
    }

    public static boolean subSequence(String t, String s){

        int n = t.length();
        int m = s.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }



}
