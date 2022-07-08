package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static class Solution {
        public int solution(int n, int[][] computers) {
            boolean[] check = new boolean[n];

            int answer = 0;

            for(int i=0; i<n; i++){
                if(!check[i]) {
                    answer++;
                    BFS(n, i, check, computers);
                }
            }

            return answer;
        }

        public void BFS(int n, int start, boolean[] check, int[][]computers) {
            Queue<Integer> queue = new LinkedList<>();
            check[start] = true;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int i = 0; i < n; i++) {
                    if (!check[i] && computers[node][i] == 1) {
                        check[i] = true;
                        queue.offer(i);
                    }
                }
            }
        }
    }
}
