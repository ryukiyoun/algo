package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3}, new boolean[]{true, false, true}));
    }

    public static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for (int i = 0; i < absolutes.length; i++)
                answer += absolutes[i] * (signs[i] ? 1 : -1);

            return answer;
        }
    }
}
