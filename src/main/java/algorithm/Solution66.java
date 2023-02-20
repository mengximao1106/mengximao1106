package algorithm;

import java.util.*;

public class Solution66 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String pre = scanner.nextLine();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pre)) {
               list.add(words[i]);
            }
        }

        if (list.isEmpty()) {
            list.add(pre);
        }
        Collections.sort(list);
        list.forEach(System.out::println);

    }
}
