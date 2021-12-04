package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        floydWarshall(5, new int[][]{{1, 2, 10}, {1, 3, 2}, {1, 4, 7}, {2, 3, 5}, {2, 5, 6}, {3, 4, 1}, {4, 5, 3}});
    }

    public static void floydWarshall(int nodeCnt, int[][] graphArr) {
        int maxValue = 1000000000;
        int[][] graph = new int[nodeCnt][nodeCnt];

        for (int i = 0; i < nodeCnt; i++) {
            Arrays.fill(graph[i], maxValue);
            graph[i][i] = 0;
        }

        for (int[] ints : graphArr) {
            graph[ints[0] - 1][ints[1] - 1] = ints[2];
            graph[ints[1] - 1][ints[0] - 1] = ints[2];
        }

        for (int i = 0; i < nodeCnt; i++) {
            for (int j = 0; j < nodeCnt; j++) {
                for (int k = 0; k < nodeCnt; k++)
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
            }
        }

        for (int i = 0; i < nodeCnt; i++) {
            for (int j = 0; j < nodeCnt; j++) {
                if (graph[i][j] == maxValue)
                    System.out.print("MAX ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
