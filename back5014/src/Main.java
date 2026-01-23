import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int topFloor;
    private static int currentFloor;
    private static int targetFloor;
    private static int upFloor;
    private static int downFloor;
    private static int[] dest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        topFloor = Integer.parseInt(st.nextToken());
        currentFloor = Integer.parseInt(st.nextToken());
        targetFloor = Integer.parseInt(st.nextToken());
        upFloor = Integer.parseInt(st.nextToken());
        downFloor = Integer.parseInt(st.nextToken()) * -1;

        dest = new int[topFloor + 1];
        Arrays.fill(dest, Integer.MAX_VALUE);

        dest[currentFloor] = -1;

        BFS(currentFloor);

        System.out.println(dest[targetFloor] == Integer.MAX_VALUE ? "use the stairs" : dest[targetFloor]);
    }

    public static void BFS(int currentFloor) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(currentFloor);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == targetFloor) {
                dest[targetFloor] = dest[current] + 1;
                break;
            }

            int calcUpFloor = current + upFloor;
            int calcDownFloor = current + downFloor;

            if (calcUpFloor <= topFloor && dest[calcUpFloor] == Integer.MAX_VALUE) {
                dest[calcUpFloor] = dest[current] + 1;
                queue.offer(calcUpFloor);
            }
            if (calcDownFloor > 0 && dest[calcDownFloor] == Integer.MAX_VALUE) {
                dest[calcDownFloor] = dest[current] + 1;
                queue.offer(calcDownFloor);
            }
        }
    }
}