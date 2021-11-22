package question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[]{1, 1}));
    }

    public static class Solution {
        public long solution(int n, int[] works) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int work : works) queue.offer(work);

            for (int i = 0; i < n; i++) {
                int work = queue.poll();

                if (work == 0)
                    break;
                else
                    queue.offer(work - 1);
            }

            long answer = 0;
            for (int sub : queue) answer += Math.pow(sub, 2);

            return answer;
        }
    }
}
