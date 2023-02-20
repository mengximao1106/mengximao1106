package algorithm;

public class solution04 {

    public static void main(String[] args) {
        String colors = "AA";
        System.out.println(winnerOfGame(colors));
    }

    public static boolean winnerOfGame(String colors) {
        int cnt = 0;
        char cur = 'C';
        int[] freq = {0, 0};
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt++;
                if (cnt >= 3) {
                    freq[c - 'A'] += 1;
                }
            }
        }
        return freq[0] > freq[1];
    }
}
