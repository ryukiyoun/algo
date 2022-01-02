package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 20, 4));
    }

    public static class Solution {
        public long solution(int price, int money, int count) {
            long[] dp = new long[count+1];
            dp[1] = price;

            for (int i=2; i<=count; i++)
                dp[i] = dp[i-1] + i * price;

            return (long)money - dp[count] < 0 ? dp[count] - (long)money : 0;
        }
    }
}
