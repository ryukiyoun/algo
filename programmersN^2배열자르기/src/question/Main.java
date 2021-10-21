package question;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(3, 2, 5);
    }

    public static class Solution {
        public int[] solution(int n, long left, long right) {
            List<Long> answer = new ArrayList<>();

            for (long i = left; i <= right; i++) {

                answer.add(Math.max(i % n, i / n) + 1);
            }

            return answer.stream().mapToInt(Long::intValue).toArray();
        }
    }
}
