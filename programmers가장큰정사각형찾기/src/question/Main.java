package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
    }

    public static class Solution {
        public int solution(int[][] board) {
            int[][] map = new int[board.length + 1][board[0].length + 1];

            int maxLen = 0;
            for (int i = 1; i <= board.length; i++) {
                for (int j = 1; j <= board[0].length; j++) {
                    if(board[i-1][j-1] != 0) {
                        int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                        map[i][j] = min + 1;

                        maxLen = Math.max(maxLen, min + 1);
                    }
                }
            }

            return maxLen * maxLen;
        }
    }
}
