package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(2, 9)));
        System.out.println(Arrays.toString(solution.solution(2, 1)));
        System.out.println(Arrays.toString(solution.solution(2, 8)));
        System.out.println(Arrays.toString(solution.solution(5, 5)));
    }

    public static class Solution {
        public int[] solution(int n, int s) {
            if (n > s)
                return new int[]{-1};

            int[] answer = new int[n];
            int share = s / n;
            int remainder = s % n;

            int index = 0;
            for (int i = 0; i < n - remainder; i++)
                answer[index++] = share;

            for (int i = 0; i < remainder; i++)
                answer[index++] = share + 1;

            return answer;
        }
    }
}
