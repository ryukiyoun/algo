package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        //System.out.println(solution.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
        System.out.println(solution.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }

    public static class Solution {
        boolean[] check;
        int[] dijkstra;

        public int solution(int N, int[][] road, int K) {
            int[][] map = new int[N + 1][N + 1];

            for (int i = 0; i < map.length; i++)
                Arrays.fill(map[i], 999999999);

            for (int i = 0; i < road.length; i++) {
                int start = road[i][0];
                int end = road[i][1];
                int length = road[i][2];

                map[start][end] = Math.min(map[start][end], length);
                map[end][start] = Math.min(map[end][start], length);
            }

            check = new boolean[N + 1];
            dijkstra = new int[N + 1];

            for (int i = 0; i <= N; i++)
                dijkstra[i] = map[1][i];

            dijkstra[1] = 0;
            check[1] = true;

            for (int i = 1; i <= N; i++) {
                int index = getMinIndex(N);
                check[index] = true;

                for (int j = 1; j <= N; j++) {
                    if (!check[j]) {
                        if (dijkstra[index] + map[index][j] < dijkstra[j])
                            dijkstra[j] = dijkstra[index] + map[index][j];
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (dijkstra[i] <= K)
                    answer++;
            }

            return answer;
        }

        public int getMinIndex(int N) {
            int min = 1000000000;
            int index = 0;

            for (int i = 1; i <= N; i++) {
                if (dijkstra[i] < min && !check[i]) {
                    min = dijkstra[i];
                    index = i;
                }
            }

            return index;
        }
    }
}
