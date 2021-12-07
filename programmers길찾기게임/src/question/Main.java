package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{10,6},{13,5},{8,4}}));
    }

    public static class Solution {
        public int[][] solution(int[][] nodeinfo) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if(o1[1] == o2[1])
                    return Integer.compare(o2[0], o1[0]);
                else
                    return Integer.compare(o2[1], o1[1]);
            });

            for(int i=0; i<nodeinfo.length; i++){
                queue.offer(new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1});
            }

            int[] rootInfo = queue.poll();
            Node root = new Node(rootInfo[0], rootInfo[2]);

            while(!queue.isEmpty()){
                int[] nodeInfo = queue.poll();
                addNode(root, new Node(nodeInfo[0], nodeInfo[2]));
            }

            List<Integer> preAnswer = new LinkedList<>();
            preOrder(root, preAnswer);

            List<Integer> postAnswer = new LinkedList<>();
            postOrder(root, postAnswer);

            return new int[][]{preAnswer.stream().mapToInt(Integer::intValue).toArray(), postAnswer.stream().mapToInt(Integer::intValue).toArray()};
        }

        public void addNode(Node parent, Node child){
            if(parent.x < child.x){
                if(parent.right == null) parent.right = child;
                else addNode(parent.right, child);
            }
            else{
                if(parent.left == null) parent.left = child;
                else addNode(parent.left, child);
            }
        }

        public void preOrder(Node node, List<Integer> answer){
            if(node != null){
                answer.add(node.number);
                preOrder(node.left, answer);
                preOrder(node.right, answer);
            }
        }

        public void postOrder(Node node, List<Integer> answer){
            if (node != null) {
                postOrder(node.left, answer);
                postOrder(node.right, answer);
                answer.add(node.number);
            }
        }

        public class Node{
            private final int x;
            private final int number;
            private Node left;
            private Node right;

            public Node(int x, int number){
                this.x = x;
                this.number = number;
                this.left = null;
                this.right = null;
            }
        }
    }
}
