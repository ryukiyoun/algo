package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }

    public static class Solution {
        public int solution(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;

            for(int i=2; i<=n; i++)
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;

            return dp[n];
        }
    }
}
