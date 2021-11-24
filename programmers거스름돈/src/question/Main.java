package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(12, new int[]{2, 5, 7}));
    }

    public static class Solution {
        public int solution(int n, int[] money) {
            int[][] dp = new int[money.length][n + 1];
            for(int i=0; i< money.length; i++)
                dp[i][0] = 1;

            for(int i=1; i<=n; i++)
                dp[0][i] = i % money[0] == 0 ? 1 : 0;

            for(int i=1; i<money.length; i++){
                for(int j=1; j<=n; j++){
                    if(money[i] <= j)
                        dp[i][j] = dp[i-1][j] + dp[i][j - money[i]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }

            return dp[money.length-1][n];
        }
    }
}
