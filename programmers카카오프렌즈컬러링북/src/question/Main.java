package question;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
    }

    public static class Solution {
        private int maxX;
        private int maxY;
        private int count = 0;
        private int max = 0;
        public int[] solution(int m, int n, int[][] picture) {
            this.maxX = n;
            this.maxY = m;
            boolean[][] check = new boolean[m][n];

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(!check[i][j] && picture[i][j] != 0) {
                        count++;
                        BFS(j, i, check, picture);
                    }
                }
            }

            return new int[] {this.count, this.max};
        }

        public void BFS(int startX, int startY, boolean[][] check, int[][] picture){
            int[] moveX = {0, 1, 0, -1};
            int[] moveY = {-1, 0, 1, 0};
            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(startX, startY));
            check[startY][startX] = true;

            int result = 0;
            while(!queue.isEmpty()){
                Point nowPoint = queue.poll();
                result++;
                int color = picture[nowPoint.y][nowPoint.x];

                for(int i=0; i<4; i++){
                    int calcX = nowPoint.x + moveX[i];
                    int calcY = nowPoint.y + moveY[i];

                    if(calcX > -1 && calcX < maxX && calcY > -1 && calcY < maxY){
                        if(color == picture[calcY][calcX] && !check[calcY][calcX]) {
                            queue.add(new Point(calcX, calcY));
                            check[calcY][calcX] = true;
                        }
                    }
                }
            }

            max = Math.max(max, result);
        }
    }
}
