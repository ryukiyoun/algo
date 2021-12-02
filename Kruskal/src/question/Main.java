package question;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static int vertexCount;
    private static int edgeCount;
    private static int[][] graph;
    private static int[] parent;

    public static void main(String[] args) {
        vertexCount = 5;
        edgeCount = 7;

        graph = new int[][]{{5, 4, 8}, {1, 2, 10}, {3, 5, 13}, {1, 4, 16},
                            {2, 3, 19}, {2, 5, 25}, {3, 1, 30}};
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        parent = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            parent[i] = i;

        int cost = 0;
        for (int i = 0; i < edgeCount; i++) {
            if (getParentValue(graph[i][0] - 1) != getParentValue(graph[i][1] - 1)) {
                merge(graph[i][0] - 1, graph[i][1] - 1);
                cost += graph[i][2];
                continue;
            }
        }

        System.out.println(cost);
    }

    public static int getParentValue(int node) {
        if (parent[node] == node)
            return node;
        else
            return getParentValue(parent[node]);
    }

    public static void merge(int startNode, int endNode) {
        int startParent = getParentValue(startNode);
        int endParent = getParentValue(endNode);

        if (startParent > endParent)
            parent[startParent] = endParent;
        else
            parent[endParent] = startParent;
    }
}
