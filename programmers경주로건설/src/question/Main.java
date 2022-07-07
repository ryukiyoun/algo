package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        //System.out.println(solution.solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
    }

    public static class Solution {
        public int solution(int[][] board) {
            return BFS(0, 0, board);
        }

        public int BFS(int startX, int startY, int[][] map) {
            int N = map.length;
            int[] moveX = {0, 0, -1, 1};
            int[] moveY = {-1, 1, 0, 0};

            int[][] cost = new int[map.length][map.length];
            for (int[] sub : cost) Arrays.fill(sub, Integer.MAX_VALUE);
            cost[startY][startX] = 0;

            boolean[][][] check = new boolean[N][N][4];
            check[startY][startX][0] = true;
            check[startY][startX][1] = true;
            check[startY][startX][2] = true;
            check[startY][startX][3] = true;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(startX, startY, -1, 0));

            int minCost = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.x == N - 1 && node.y == N - 1)
                    minCost = Math.min(minCost, node.cost);
                else {
                    for (int i = 0 ; i < 4 ; i++) {
                        int movePointX = node.x + moveX[i];
                        int movePointY = node.y + moveY[i];

                        if (0 <= movePointX && movePointX < N && 0 <= movePointY && movePointY < N && map[movePointY][movePointX] == 0) {
                            int calcCost = node.beforeMove == -1 || node.beforeMove == i ? node.cost + 100 : node.cost + 600;
                            if (!check[movePointY][movePointX][i] || cost[movePointY][movePointX] >= calcCost) {
                                queue.offer(new Node(movePointX, movePointY, i, calcCost));
                                check[movePointY][movePointX][i] = true;
                                cost[movePointY][movePointX] = calcCost;
                            }
                        }
                    }
                }
            }

            return minCost;
        }

        public static class Node {
            private final int x;
            private final int y;
            private final int beforeMove;
            private final int cost;

            public Node(int x, int y, int beforeMove, int cost) {
                this.x = x;
                this.y = y;
                this.beforeMove = beforeMove;
                this.cost = cost;
            }
        }
    }
}
