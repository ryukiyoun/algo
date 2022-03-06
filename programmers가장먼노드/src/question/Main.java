package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
        System.out.println(solution.solution(8, new int[][]{{1, 2}, {2, 3}, {2, 5}, {5, 6}, {1, 4}, {4, 7}, {4, 8}}));
    }

    public static class Solution {
        public int solution(int n, int[][] edge) {
            boolean[][] map = new boolean[n + 1][n + 1];
            int[] check = new int[n + 1];

            for (int[] sub : edge) {
                map[sub[0]][sub[1]] = true;
                map[sub[1]][sub[0]] = true;
            }

            BFS(1, map, check);

            Arrays.sort(check);

            int answer = 1;
            int max = check[check.length - 1];
            for (int i = check.length - 2; i > -1; i--) {
                if(check[i] == max)
                    answer++;
                else
                    break;
            }
            return answer;
        }

        public void BFS(int start, boolean[][] map, int[] check) {
            Queue<Integer> queue = new LinkedList<>();
            check[start] = 1;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int i = 1; i < map.length; i++) {
                    if (check[i] == 0 && map[node][i]) {
                        check[i] = check[node] + 1;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
