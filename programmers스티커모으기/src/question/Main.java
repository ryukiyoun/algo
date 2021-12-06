package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2}));
    }

    public static class Solution {
        public int solution(int sticker[]) {
            if(sticker.length == 1)
                return sticker[0];

            int[] dp = new int[sticker.length + 2];

            for (int i = 3; i < dp.length; i++)
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);
            int secondMax = dp[dp.length - 1];

            for (int i = 2; i < dp.length; i++)
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 2]);
            int firstMax = dp[dp.length - 2];

            return Math.max(firstMax, secondMax);
        }
    }
}
