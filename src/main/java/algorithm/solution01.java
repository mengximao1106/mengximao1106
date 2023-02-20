package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class solution01 {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
    }

    public static int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        Queue<String> queue = getQueue(text);
        List<String> balloons = getList(balloon);
        int count = 0;
        while (!queue.isEmpty()) {
            if (!balloons.contains(queue.peek()) && balloon.contains(queue.peek())) {
                queue.add(queue.poll());
                continue;
            }
            String s = queue.poll();
            if (balloons.contains(s)) {
                balloons.remove(s);
            }

            if (balloons.size() == 0) {
                count++;
                balloons = getList(balloon);
            }
        }

        return count;
    }

    private static List<String> getList(String balloon) {
        List<String> balloons = new ArrayList<>();
        for (int i = 0; i < balloon.length(); i++) {
            balloons.add(String.valueOf(balloon.charAt(i)));
        }
        return balloons;
    }

    private static Queue<String> getQueue(String text) {
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            queue.add(String.valueOf(text.charAt(i)));
        }
        return queue;
    }
}
