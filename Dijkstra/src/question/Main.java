package question;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        loopDijkstra(1, 5, new int[][]{{1, 2, 10}, {1, 3, 2}, {1, 4, 7}, {2, 3, 5}, {2, 5, 6}, {3, 4, 1}, {4, 5, 3}});
        queueDijkstra(1, 5, new int[][]{{1, 2, 10}, {1, 3, 2}, {1, 4, 7}, {2, 3, 5}, {2, 5, 6}, {3, 4, 1}, {4, 5, 3}});
    }

    public static void loopDijkstra(int startNum, int nodeCnt, int[][] graphArr) {
        List<List<DestNode>> graph = new ArrayList<>();
        for (int i = 0; i < nodeCnt + 1; i++)
            graph.add(new ArrayList<>());

        for (int[] ints : graphArr) {
            graph.get(ints[0]).add(new DestNode(ints[1], ints[2]));
            graph.get(ints[1]).add(new DestNode(ints[0], ints[2]));
        }

        boolean[] check = new boolean[nodeCnt + 1];

        int[] costs = new int[nodeCnt + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[startNum] = 0;

        for (int i = 0; i < nodeCnt; i++) {
            int minCost = Integer.MAX_VALUE;
            int minNodeNum = 0;

            for (int j = 1; j < costs.length; j++) {
                if (!check[j] && minCost > costs[j]) {
                    minCost = costs[j];
                    minNodeNum = j;
                }
            }

            check[minNodeNum] = true;

            for (int j = 0; j < graph.get(minNodeNum).size(); j++) {
                DestNode node = graph.get(minNodeNum).get(j);

                if (costs[node.destNum] > node.cost + costs[minNodeNum])
                    costs[node.destNum] = node.cost + costs[minNodeNum];
            }
        }

        System.out.println(Arrays.toString(costs));
    }

    public static void queueDijkstra(int startNum, int nodeCnt, int[][] graphArr) {
        List<List<DestNode>> graph = new ArrayList<>();
        for (int i = 0; i < nodeCnt + 1; i++)
            graph.add(new ArrayList<>());

        for (int[] ints : graphArr) {
            graph.get(ints[0]).add(new DestNode(ints[1], ints[2]));
            graph.get(ints[1]).add(new DestNode(ints[0], ints[2]));
        }

        int[] costs = new int[nodeCnt + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[startNum] = 0;

        Queue<DestNode> queue = new LinkedList<>();
        queue.offer(new DestNode(startNum, 0));

        while (!queue.isEmpty()) {
            DestNode node = queue.poll();

            for (int i = 0; i < graph.get(node.destNum).size(); i++) {
                DestNode compareNode = graph.get(node.destNum).get(i);

                if (costs[compareNode.destNum] > node.cost + compareNode.cost) {
                    queue.offer(new DestNode(compareNode.destNum, node.cost + compareNode.cost));
                    costs[compareNode.destNum] = node.cost + compareNode.cost;
                }
            }
        }

        System.out.println(Arrays.toString(costs));
    }

    public static class DestNode {
        private final int destNum;
        private final int cost;

        public DestNode(int destNum, int cost) {
            this.destNum = destNum;
            this.cost = cost;
        }
    }
}
