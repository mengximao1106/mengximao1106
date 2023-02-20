package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution61 {

    static TreeMap<Integer, Integer> map = new TreeMap<>();
    private static int HEAD = 0;
    private static final int TAIL = 100;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < len; i++) {
            String s = scanner.nextLine();
            String[] params = s.split("=");
            String command = params[0];
            int size = Integer.valueOf(params[1]);
            if ("REQUEST".equals(command)) {
                request(size);
            }else {
                release(size);
            }
        }
    }

    public static void request(int size) {
        int addressHead = HEAD;

        if (map.isEmpty()) {
            map.put(HEAD, size);
            System.out.println(HEAD);
            return;
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            int offset = list.get(i);
            if (offset - addressHead >= size) {
                map.put(addressHead, size + addressHead);
            } else {
                addressHead = map.get(list.get(i));
            }
        }

        if (TAIL - addressHead >= size) {
            map.put(addressHead, size + addressHead);
        } else {
            System.out.println("error");
        }

        System.out.println(addressHead);
    }

    public static void release(int address) {
        if (map.containsKey(address)) {
            map.remove(address);
        }else {
            System.out.println("error");
        }
    }

}
