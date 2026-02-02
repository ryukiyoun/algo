import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    private static final Point[] moves = new Point[]{new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1)};
    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            answer++;
            List<Federation> federations = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        visit[i][j] = true;
                        Federation federation = BFS(j, i);
                        federations.add(federation);
                    }
                }
            }

            for(Federation federation : federations)
                federation.reorder();

            if (federations.size() == N * N)
                break;

            for (int i = 0; i < N; i++)
                Arrays.fill(visit[i], false);
        }

        System.out.println(answer - 1);
    }

    public static Federation BFS(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));

        Federation federation = new Federation();
        federation.appendCountry(x, y);

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (Point move : moves) {
                int calcX = current.x + move.x;
                int calcY = current.y + move.y;

                if (!(0 <= calcX && calcX < N && 0 <= calcY && calcY < N)) continue;
                if (visit[calcY][calcX]) continue;

                int gap = Math.abs(map[current.y][current.x] - map[calcY][calcX]);

                if (L <= gap && gap <= R) {
                    visit[calcY][calcX] = true;
                    federation.appendCountry(calcX, calcY);
                    queue.offer(new Point(calcX, calcY));
                }
            }
        }

        return federation;
    }

    public static class Federation {
        List<Point> countries = new ArrayList<>();
        int people = 0;

        public void appendCountry(int x, int y) {
            countries.add(new Point(x, y));
            people += map[y][x];
        }

        public void reorder() {
            int rePeople = people / countries.size();
            for (Point point : countries)
                map[point.y][point.x] = rePeople;
        }
    }
}