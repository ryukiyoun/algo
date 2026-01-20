import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main {
    private final static Point[] moves = {new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1)};
    private static int[][] graph;
    private static int M;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    graph[y][x] = -1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        int blockNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[j][i] == 0) {
                    answer.add(BFS(i, j, blockNum++));
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();

        sb.append(answer.size()).append("\n");
        for(int r : answer) {
            sb.append(r).append(" ");
        }

        System.out.println(sb+"");
    }

    public static int BFS(int x, int y, int blockNum) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        graph[y][x] = blockNum;

        int extent = 1;
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (Point move : moves) {
                int calcX = current.x + move.x;
                int calcY = current.y + move.y;

                if (0 <= calcX && 0 <= calcY && calcX < N && calcY < M && graph[calcY][calcX] == 0) {
                    graph[calcY][calcX] = blockNum;
                    queue.add(new Point(calcX, calcY));
                    extent++;
                }
            }
        }

        return extent;
    }
}

// AI 최적화
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    private static int[][] graph;
//    private static int M, N;
//    private static final int[] dx = {1, -1, 0, 0};
//    private static final int[] dy = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        graph = new int[M][N];
//
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//
//            for (int y = y1; y < y2; y++) {
//                for (int x = x1; x < x2; x++) {
//                    graph[y][x] = -1;
//                }
//            }
//        }
//
//        List<Integer> answer = new ArrayList<>();
//
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                if (graph[i][j] == 0) {
//                    answer.add(bfs(j, i));
//                }
//            }
//        }
//
//        Collections.sort(answer);
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(answer.size()).append('\n');
//        for (int size : answer) {
//            sb.append(size).append(' ');
//        }
//
//        System.out.print(sb);
//    }
//
//    private static int bfs(int x, int y) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(y * N + x);  // 좌표를 하나의 정수로 인코딩
//        graph[y][x] = 1;
//
//        int extent = 1;
//
//        while (!queue.isEmpty()) {
//            int pos = queue.poll();
//            int cy = pos / N;
//            int cx = pos % N;
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//
//                if (nx >= 0 && ny >= 0 && nx < N && ny < M && graph[ny][nx] == 0) {
//                    graph[ny][nx] = 1;
//                    queue.offer(ny * N + nx);
//                    extent++;
//                }
//            }
//        }
//
//        return extent;
//    }
//}