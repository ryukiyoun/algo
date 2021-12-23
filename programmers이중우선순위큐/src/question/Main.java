package question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"I 16","D 1"}));
    }

    public static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (String sub : operations) {
                String[] split = sub.split(" ");
                int num = Integer.parseInt(split[1]);

                switch (split[0]) {
                    case "I":
                        reverseQueue.offer(num);
                        queue.offer(num);
                        break;
                    case "D":
                        if (!reverseQueue.isEmpty()) {
                            if (num < 0)
                                reverseQueue.remove(queue.poll());
                            else
                                queue.remove(reverseQueue.poll());
                        }
                        break;
                }
            }

            int[] answer = new int[2];

            if(!reverseQueue.isEmpty()) {
                answer[0] = reverseQueue.poll();
                answer[1] = queue.poll();
            }

            return answer;
        }
    }
}
