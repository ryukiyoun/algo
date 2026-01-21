import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] xMove = {1, -1, 0, 0};
    private static final int[] yMove = {0, 0, 1, -1};
    private static int[][] graph;
    private static int X;
    private static int Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        int paintingCnt = 0;
        int maxExtent = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (graph[j][i] == 1) {
                    maxExtent = Math.max(maxExtent, BFS(i, j));
                    paintingCnt++;
                }
            }
        }


        System.out.println(paintingCnt);
        System.out.println(maxExtent);
    }

    public static int BFS(int x, int y) {
        int extent = 1;
        graph[y][x] = 2;

        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{x, y});

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int calcX = current[0] + xMove[i];
                int calcY = current[1] + yMove[i];

                if (0 <= calcX && 0 <= calcY && calcX < X && calcY < Y && graph[calcY][calcX] == 1) {
                    queue.add(new Integer[]{calcX, calcY});
                    graph[calcY][calcX] = 2;
                    extent++;
                }
            }
        }

        return extent;
    }
}

//AI 최적화
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    private static final int[] xMove = {1, -1, 0, 0};
//    private static final int[] yMove = {0, 0, 1, -1};
//    private static int[][] graph;
//    private static int X;
//    private static int Y;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Y = Integer.parseInt(st.nextToken());
//        X = Integer.parseInt(st.nextToken());
//
//        graph = new int[Y][X];
//        for (int i = 0; i < Y; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < X; j++)
//                graph[i][j] = Integer.parseInt(st.nextToken());
//        }
//
//        int paintingCnt = 0;
//        int maxExtent = 0;
//
//        for (int i = 0; i < Y; i++) {
//            for (int j = 0; j < X; j++) {
//                if (graph[i][j] == 1) {
//                    int extent = BFS(j, i);
//                    maxExtent = Math.max(maxExtent, extent);
//                    paintingCnt++;
//                }
//            }
//        }
//
//        System.out.println(paintingCnt);
//        System.out.println(maxExtent);
//    }
//
//    public static int BFS(int x, int y) {
//        int extent = 1;
//        graph[y][x] = 0;
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(y * X + x);  // 좌표를 정수로 인코딩
//
//        while (!queue.isEmpty()) {
//            int pos = queue.poll();
//            int cy = pos / X;
//            int cx = pos % X;
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + xMove[i];
//                int ny = cy + yMove[i];
//
//                if (nx >= 0 && ny >= 0 && nx < X && ny < Y && graph[ny][nx] == 1) {
//                    graph[ny][nx] = 0;
//                    queue.offer(ny * X + nx);
//                    extent++;
//                }
//            }
//        }
//
//        return extent;
//    }
//}