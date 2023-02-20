package algorithm;

public class solution06 {

    public static void main(String[] args) {
        System.out.println(printStr(8));
    }

    /**
     * 1
     * 32
     * 456
     * @param maxNum
     * @return
     */
    public static String printStr(int maxNum) {

        String blank = "    ";
        String star = "*";
        int idx = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxNum; i++) {
            for (int j = 0; j < maxNum - i; j++) {
                sb.append(blank);
            }
            //正序
            if (i % 2 == 1) {
                for (int j = idx; j < idx + i; j++) {
                    sb.append(printAppendStar(j, star));
                    sb.append(blank);
                }
            }
            //倒序
            if (i % 2 == 0) {
                for (int j = idx + i -1; j >= idx; j--) {
                    sb.append(printAppendStar(j, star));
                    sb.append(blank);
                }
            }
            idx += i;
            if (i != maxNum) {
                sb.append("\n");
            }
        }
        return  sb.toString();
    }

    public static  String printAppendStar(int num, String star){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int count = 4 - (int) Math.log10(num) - 1;
        for (int i = 0; i < count; i++) {
            sb.append(star);
        }
        return sb.toString();
    }
}
