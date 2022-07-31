import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        solution.solution(new String[]{"a", "b"}, 2);
    }

    public static class Solution {
        private List<String> list;

        public void solution(String[] arr, int len) {
            boolean[] check = new boolean[arr.length];
            System.out.println("Combination");
            combination(arr, 0, len, check);
            System.out.println("--------------------------------");
            System.out.println("Permutation");
            check = new boolean[arr.length];
            permutation(arr, 0, len, check, "");
            System.out.println("--------------------------------");
        }

        public void combination(String[] arr, int index, int r, boolean[] check) {
            if (r == 0) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i])
                        System.out.print(arr[i]);
                }
                System.out.println();
            } else {
                for (int i = index; i < arr.length; i++) {
                    check[i] = true;
                    combination(arr, i + 1, r - 1, check);
                    check[i] = false;
                }
            }
        }

        public void permutation(String[] arr, int startDepth, int endDepth, boolean[] check, String result) {
            if (startDepth == endDepth)
                System.out.println(result);
            else {
                for (int i = 0; i < arr.length; i++) {
                    if (!check[i]) {
                        check[i] = true;
                        permutation(arr, startDepth + 1, endDepth, check, result + arr[i]);
                        check[i] = false;
                    }
                }
            }
        }

        public static void loopDijkstra2(int startNum, int nodeCnt, int[][] graphArr) {
            List<List<DestNode>> graph = new ArrayList<>();
            for (int i = 0; i < nodeCnt; i++)
                graph.add(new ArrayList<>());

            for (int[] ints : graphArr) {
                graph.get(ints[0] - 1).add(new DestNode(ints[1] - 1, ints[2]));
                graph.get(ints[1] - 1).add(new DestNode(ints[0] - 1, ints[2]));
            }

            boolean[] check = new boolean[nodeCnt];
            check[startNum - 1] = true;

            int[] costs = new int[nodeCnt];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[startNum - 1] = 0;

            for (int i = 0; i < nodeCnt; i++) {
                int minCost = Integer.MAX_VALUE;
                int minNum = 0;

                for (int j = 0; j < nodeCnt; j++) {
                    if (!check[i] && minCost > costs[i]) {
                        minCost = costs[i];
                        minNum = i;
                    }
                }

                check[i] = true;

                for (int j = 0; j < graph.get(minNum).size(); j++) {
                    DestNode node = graph.get(minNum).get(j);

                    if (costs[node.destNum] > costs[minNum] + node.cost)
                        costs[node.destNum] = costs[minNum] + node.cost;
                }
            }
        }
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
