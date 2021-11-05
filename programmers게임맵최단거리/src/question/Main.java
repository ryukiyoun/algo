package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        //System.out.println(solution.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
        System.out.println(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public static class Solution {
        int maxRight;
        int maxBottom;
        int[][] maps;
        boolean[][] check;
        public int solution(int[][] maps) {
            this.maps = maps;

            maxRight = maps[0].length;
            maxBottom = maps.length;

            check = new boolean[maxBottom][maxRight];
            return move(0, 0);
        }

        public int move(int x, int y){
            int[] moveX = {0, 0, 1, -1};
            int[] moveY = {1, -1, 0, 0};
            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(x, y, 1));

            while(!queue.isEmpty()){
                Point now = queue.poll();

                if(now.x == maxRight - 1 && now.y == maxBottom -1)
                    return now.range;

                for(int i=0; i<4; i++) {
                    int calcX = now.x + moveX[i];
                    int calcY = now.y + moveY[i];

                    if (calcX > -1 && calcX < maxRight && calcY > -1 && calcY < maxBottom) {
                        if(maps[calcY][calcX] == 1 && !check[calcY][calcX]){
                            check[calcY][calcX] = true;
                            queue.add(new Point(calcX, calcY, now.range + 1));
                        }
                    }
                }
            }

            return -1;
        }

        public class Point{
            int x;
            int y;
            int range;

            public Point(int x, int y, int range){
                this.x = x;
                this.y = y;
                this.range = range;
            }
        }
    }
}
