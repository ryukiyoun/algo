package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(solution.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static class Solution {
        public int solution(int[] A, int[] B) {
            PriorityQueue<Integer> aQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> bQueue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < A.length; i++) {
                aQueue.offer(A[i]);
                bQueue.offer(B[i]);
            }

            int answer = 0;
            while (!aQueue.isEmpty()) {
                int aNum = aQueue.poll();
                int bNum = bQueue.peek();

                if (aNum < bNum) {
                    bQueue.poll();
                    answer++;
                }
            }

            return answer;
        }
    }
}
