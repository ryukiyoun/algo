package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }

    public static class Solution {
        private int[][] cityMap;
        private int[][] map;

        public int solution(int m, int n, int[][] cityMap) {
            int MOD = 20170805;
            this.cityMap = cityMap;
            map = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 && j == 1)
                        map[i][j] = 1;
                    else {
                        if (cityMap[i - 1][j - 1] == 0)
                            map[i][j] = (getTopValue(i, j) + getLeftValue(i, j)) % MOD;
                        else
                            map[i][j] = 0;
                    }
                }
            }

            return map[m][n];
        }

        public int getTopValue(int rowIndex, int columnIndex) {
            for (int i = rowIndex - 1; i > 0; i--) {
                if (cityMap[i - 1][columnIndex - 1] != 2)
                    return map[i][columnIndex];
            }

            return 0;
        }

        public int getLeftValue(int rowIndex, int columnIndex) {
            for (int i = columnIndex - 1; i > 0; i--) {
                if (cityMap[rowIndex - 1][i - 1] != 2)
                    return map[rowIndex][i];
            }

            return 0;
        }
    }
}
