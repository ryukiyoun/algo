package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[]{7, 10}));
    }

    public static class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);

            long left = 0;
            long right = (long) times[times.length - 1] * (long) n;

            while (left != right) {
                long mid = (left + right) / 2;

                int count = 0;
                for (int i = 0; i < times.length; i++)
                    count += mid / times[i];

                if (count >= n)
                    right = mid;
                else
                    left = mid + 1;
            }

            return left;
        }
    }
}
