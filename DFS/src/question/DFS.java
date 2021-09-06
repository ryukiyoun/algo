package question;

import java.util.Random;

public class DFS {
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(5);
        PrintDFS dfs = new PrintDFS(graph);

        dfs.startSearch(0);

        System.out.println();
    }

    public static class DFSGraph {
        private int nodeCnt;
        private boolean[][] dfsGraph;
        private boolean[] visitList;

        public DFSGraph(int nodeCnt) {
            this.nodeCnt = nodeCnt;

            this.dfsGraph = new boolean[this.nodeCnt][this.nodeCnt];

            this.visitList = new boolean[this.nodeCnt];

            int loop = 0;
            Random random = new Random();

            while (loop < nodeCnt) {
                int link;

                while (true) {
                    link = random.nextInt(nodeCnt - 1);
                    if (link != loop)
                        break;
                }

                dfsGraph[loop][link] = true;
                dfsGraph[link][loop] = true;
                loop++;
            }
        }

        public void addVisitNode(int nodeNum) {
            visitList[nodeNum] = true;
        }
    }

    public static class PrintDFS {
        private DFSGraph dfsGraph;

        public PrintDFS(DFSGraph dfsGraph) {
            this.dfsGraph = dfsGraph;
        }

        public void startSearch(int startNodeNum) {
            this.dfsGraph.addVisitNode(startNodeNum);

            System.out.print(startNodeNum + " ");

            for (int i = 0; i < this.dfsGraph.dfsGraph[startNodeNum].length; i++) {
                if (this.dfsGraph.dfsGraph[startNodeNum][i] && !this.dfsGraph.visitList[i])
                    startSearch(i);
            }
        }
    }
}
