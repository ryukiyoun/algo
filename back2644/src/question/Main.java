package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int MAX = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int peopleNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int startNumber = Integer.parseInt(st.nextToken());
        int endNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int loop = Integer.parseInt(st.nextToken());

        int[] chon = new int[peopleNumber + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < peopleNumber + 1; i++) {
            chon[i] = MAX;
            map.put(i, new ArrayList<>());
        }

        chon[startNumber] = 0;

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            map.get(parent).add(child);
            map.get(child).add(parent);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNumber);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();

            map.get(start).forEach(el -> {
                if (chon[el] == MAX) {
                    chon[el] = chon[start] + 1;
                    queue.add(el);
                }
            });
        }

        System.out.println(chon[endNumber] == MAX ? -1 : chon[endNumber]);
    }
}


// AI 최적화 코드
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int peopleNumber = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int startNumber = Integer.parseInt(st.nextToken());
//        int endNumber = Integer.parseInt(st.nextToken());
//
//        int loop = Integer.parseInt(br.readLine());
//
//        boolean[] visited = new boolean[peopleNumber + 1];
//        int[] distance = new int[peopleNumber + 1];
//
//        List<Integer>[] graph = new ArrayList[peopleNumber + 1];
//        for (int i = 0; i <= peopleNumber; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < loop; i++) {
//            st = new StringTokenizer(br.readLine());
//            int parent = Integer.parseInt(st.nextToken());
//            int child = Integer.parseInt(st.nextToken());
//
//            graph[parent].add(child);
//            graph[child].add(parent);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(startNumber);
//        visited[startNumber] = true;
//
//        boolean found = false;
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//
//            if (current == endNumber) {
//                found = true;
//                break;
//            }
//
//            for (int next : graph[current]) {
//                if (!visited[next]) {
//                    visited[next] = true;
//                    distance[next] = distance[current] + 1;
//                    queue.offer(next);
//                }
//            }
//        }
//
//        System.out.println(found ? distance[endNumber] : -1);
//
//        br.close();
//    }
//}