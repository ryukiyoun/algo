import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int peopleNum = Integer.parseInt(st.nextToken());
        int loopCnt = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[peopleNum + 1];
        for (int i = 0; i <= peopleNum; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < loopCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            graph[start].add(target);
            graph[target].add(start);
        }

        int[][] answer = new int[peopleNum + 1][peopleNum + 1];
        for (int i = 0; i <= peopleNum; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
            answer[i][i] = 0;
        }

        for (int i = 0; i < peopleNum; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i + 1);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (Integer target : graph[current]) {
                    if (answer[i + 1][target] == Integer.MAX_VALUE) {
                        answer[i + 1][target] = answer[i + 1][current] + 1;
                        queue.offer(target);
                    }
                }
            }
        }

        List<Integer[]> dap = new ArrayList<>();
        for (int i = 1; i <= peopleNum; i++) {
            int sum = 0;

            for (int j = 1; j <= peopleNum; j++) {
                sum += answer[i][j];
            }

            dap.add(new Integer[] {i,sum});
        }

        dap.sort((o1, o2) -> {
            if(o1[1] < o2[1])
                return -1;
            if(o1[1] > o2[1])
                return 1;

            return o1[0] < o2[0] ? -1 : 1;
        });

        System.out.println(dap.get(0)[0]);
    }
}

// AI 최적화
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int peopleNum = Integer.parseInt(st.nextToken());
//        int loopCnt = Integer.parseInt(st.nextToken());
//
//        List<Integer>[] graph = new ArrayList[peopleNum + 1];
//        for (int i = 1; i <= peopleNum; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < loopCnt; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int target = Integer.parseInt(st.nextToken());
//
//            graph[start].add(target);
//            graph[target].add(start);
//        }
//
//        int minSum = Integer.MAX_VALUE;
//        int minPerson = 1;
//
//        for (int start = 1; start <= peopleNum; start++) {
//            int[] distances = new int[peopleNum + 1];
//            Arrays.fill(distances, -1);
//            distances[start] = 0;
//
//            Queue<Integer> queue = new ArrayDeque<>();
//            queue.offer(start);
//
//            while (!queue.isEmpty()) {
//                int current = queue.poll();
//
//                for (int neighbor : graph[current]) {
//                    if (distances[neighbor] == -1) {
//                        distances[neighbor] = distances[current] + 1;
//                        queue.offer(neighbor);
//                    }
//                }
//            }
//
//            int sum = 0;
//            for (int i = 1; i <= peopleNum; i++) {
//                sum += distances[i];
//            }
//
//            if (sum < minSum) {
//                minSum = sum;
//                minPerson = start;
//            }
//        }
//
//        System.out.println(minPerson);
//    }
//}