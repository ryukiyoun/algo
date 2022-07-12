package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    public static class Solution {
        int solution(int[][] land) {
            int[][] answer = new int[land.length][4];
            answer[0] = land[0];

            for (int i = 1; i < land.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0)
                        answer[i][j] = Math.max(answer[i - 1][1], Math.max(answer[i - 1][2], answer[i - 1][3])) + land[i][j];
                    else if (j == 1)
                        answer[i][j] = Math.max(answer[i - 1][0], Math.max(answer[i - 1][2], answer[i - 1][3])) + land[i][j];
                    else if (j == 2)
                        answer[i][j] = Math.max(answer[i - 1][0], Math.max(answer[i - 1][1], answer[i - 1][3])) + land[i][j];
                    else
                        answer[i][j] = Math.max(answer[i - 1][0], Math.max(answer[i - 1][1], answer[i - 1][2])) + land[i][j];
                }
            }

            return Arrays.stream(answer[land.length - 1]).max().getAsInt();
        }
    }
}
