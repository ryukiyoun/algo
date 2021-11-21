package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 3, new int[][]{{2, 2}}));
    }

    public static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] map = new int[n + 1][m + 1];

            for (int[] puddle : puddles) map[puddle[1]][puddle[0]] = Integer.MAX_VALUE;

            map[1][1] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if(map[i][j] == Integer.MAX_VALUE)
                        map[i][j] = 0;
                    else if (!(i == 1 && j == 1))
                        map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                }
            }

            return map[n][m];
        }
    }
}
