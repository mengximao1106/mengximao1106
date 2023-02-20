package algorithm;

import java.util.*;

public class solution14 {

    /*public static void main(String[] args) {
        System.out.println(resetArticle("hello world!", 0, 1));
    }

    public static String resetArticle(String article, int s, int t) {

        String[] articles = article.split(" ");
        if (articles.length - 1 < t) {
            return "EMPTY";
        }
        String tmp = articles[s];
        articles[s] = articles[t];
        articles[t] = tmp;
        return Arrays.toString(articles);
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.valueOf(scanner.nextLine());
        int n = Integer.valueOf(scanner.nextLine());
        String firstWord = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n -1; i++) {
            if (i == k) {
                firstWord = scanner.nextLine();
            }else {
                list.add(scanner.nextLine());
            }
        }

        Collections.sort(list);
        Collections.sort(list, (s1, s2) -> s2.length() - s1.length());
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        sb.append(firstWord);
        String key = firstWord.substring(firstWord.length() -1);
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.startsWith(key)) {
                sb.append(word);
                key = word.substring(word.length() -1);
            }
        }
        System.out.println(sb);
    }
}
