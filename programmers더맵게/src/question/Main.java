package question;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    public static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j : scoville) queue.offer(j);

            int answer = 0;
            while (queue.size() > 1 && queue.peek() < K) {
                queue.offer(queue.poll() + queue.poll() * 2);
                answer++;
            }

            return queue.poll() >= K ? answer : -1;
        }
    }
}
