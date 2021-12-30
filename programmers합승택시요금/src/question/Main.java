package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution.solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution.solution(6, 4, 5, 6, new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }

    public static class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int INF = 1000000000;
            int[][] costs = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(costs[i], INF);
                costs[i][i] = 0;
            }

            for (int[] fare : fares)
                costs[fare[0] - 1][fare[1] - 1] = costs[fare[1] - 1][fare[0] - 1] = fare[2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++)
                        costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                }
            }

            int answer = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if(costs[s - 1][i] != INF && costs[i][a - 1] != INF && costs[i][b - 1] != INF)
                    answer = Math.min(answer, costs[s - 1][i] + costs[i][a - 1] + costs[i][b - 1]);
            }

            return answer;
        }
    }
}
