package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 6, 76}, new int[]{5, 6, 76}));
    }

    public static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++)
                answer += A[i] * B[B.length - 1 - i];

            return answer;
        }
    }
}
