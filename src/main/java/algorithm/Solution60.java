package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Solution60 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(area(s1, s2, s3));
    }

    private static long area(String s1, String s2, String s3) {

        if (!isIntersect(s1, s2)){
            return 0;
        }

        String intersect = intersectRectangle(s1, s2);
        System.out.println("A and B intersect rectangle: " + intersect);
        if (!isIntersect(intersect, s3)) {
            return 0;
        }
        return intersectArea(intersect, s3);
    }

    private static long intersectArea(String s1, String s2) {
        String s = intersectRectangle(s1, s2);
        String[] s3 = s.split(" ");
        System.out.println("A B C intersect: " + Arrays.toString(s3));
        return Long.valueOf(s3[2]) * Long.valueOf(s3[3]);
    }

    private static String intersectRectangle(String s1, String s2) {
        int s1xMin, s1xMax, s1yMin, s1yMax, s2xMin, s2xMax, s2yMin, s2yMax;

        String[] arr1 = s1.split(" ");
        s1xMax = Integer.valueOf(arr1[0]) + Integer.valueOf(arr1[2]);
        s1yMax = Integer.valueOf(arr1[1]);
        s1xMin = Integer.valueOf(arr1[0]);
        s1yMin = Integer.valueOf(arr1[1]) - Integer.valueOf(arr1[3]);

        String[] arr2 = s2.split(" ");
        s2xMin = Integer.valueOf(arr2[0]);
        s2yMin = Integer.valueOf(arr2[1]) - Integer.valueOf(arr2[3]);
        s2xMax = Integer.valueOf(arr2[0]) + Integer.valueOf(arr2[2]);
        s2yMax = Integer.valueOf(arr2[1]);

        //相交：取小的里面的大的，大的里面的小的
        int intersectXMin = Math.max(s1xMin, s2xMin);

        int intersectXMax = Math.min(s1xMax, s2xMax);

        int intersectYMin = Math.max(s1yMin, s2yMin);

        int intersectYMax = Math.min(s1yMax, s2yMax);

        StringBuilder sb = new StringBuilder();
        sb.append(intersectXMin);
        sb.append(" ");
        sb.append(intersectYMax);
        sb.append(" ");
        sb.append(intersectXMax - intersectXMin);
        sb.append(" ");
        sb.append(intersectYMax - intersectYMin);

        return sb.toString();
    }

    private static boolean isIntersect(String s1, String s2) {
        int s1xMax, s1yMax, s2xMin, s2yMin;

        String[] arr1 = s1.split(" ");
        s1xMax = Integer.valueOf(arr1[0]) + Integer.valueOf(arr1[2]);
        s1yMax = Integer.valueOf(arr1[1]);

        String[] arr2 = s2.split(" ");
        s2xMin = Integer.valueOf(arr2[0]);
        s2yMin = Integer.valueOf(arr2[1]) - Integer.valueOf(arr2[3]);

        if (s1xMax <= s2xMin || s1yMax <= s2yMin) {
            return false;
        }

        return true;
    }

}
