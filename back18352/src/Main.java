import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int bridgeNum = Integer.parseInt(st.nextToken());
        int targetLength = Integer.parseInt(st.nextToken());
        int startNodeNum = Integer.parseInt(st.nextToken());

        int[] answer = new int[nodeNum + 1];
        List<Integer>[] map = new ArrayList[nodeNum + 1];

        for (int i = 0; i < nodeNum + 1; i++) {
            answer[i] = Integer.MAX_VALUE;
            map[i] = new ArrayList<>();
        }

        answer[startNodeNum] = 0;

        for (int i = 0; i < bridgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int destNode = Integer.parseInt(st.nextToken());

            map[startNode].add(destNode);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNodeNum);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (int dest : map[start]) {
                if (answer[dest] > answer[start] + 1) {
                    answer[dest] = answer[start] + 1;
                    queue.offer(dest);
                }
            }
        }

        boolean trigger = false;
        for (int i = 1; i < nodeNum + 1; i++) {
            if (answer[i] == targetLength) {
                System.out.println(i);
                trigger = true;
            }
        }

        if(!trigger)
            System.out.println(-1);
    }
}

// AI 최적화
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int nodeNum = Integer.parseInt(st.nextToken());
//        int bridgeNum = Integer.parseInt(st.nextToken());
//        int targetLength = Integer.parseInt(st.nextToken());
//        int startNodeNum = Integer.parseInt(st.nextToken());
//
//        // distance 배열 초기화
//        int[] distance = new int[nodeNum + 1];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[startNodeNum] = 0;
//
//        // 그래프 초기화
//        List<Integer>[] graph = new ArrayList[nodeNum + 1];
//        for (int i = 1; i <= nodeNum; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // 간선 정보 입력
//        for (int i = 0; i < bridgeNum; i++) {
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int dest = Integer.parseInt(st.nextToken());
//            graph[start].add(dest);
//        }
//
//        // BFS (ArrayDeque 사용)
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(startNodeNum);
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            int currentDist = distance[current];
//
//            for (int next : graph[current]) {
//                // 더 짧은 경로를 찾았을 때만 갱신
//                if (distance[next] > currentDist + 1) {
//                    distance[next] = currentDist + 1;
//                    queue.offer(next);
//                }
//            }
//        }
//
//        // 결과 출력 (StringBuilder 사용)
//        StringBuilder sb = new StringBuilder();
//        boolean found = false;
//
//        for (int i = 1; i <= nodeNum; i++) {
//            if (distance[i] == targetLength) {
//                sb.append(i).append('\n');
//                found = true;
//            }
//        }
//
//        System.out.print(found ? sb : "-1\n");
//    }
//}