package question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] weights = solution.solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"});

        for (int i = 0; i < weights.length; i++)
            System.out.println(weights[i]);
    }

    public static class Solution {
        public int[] solution(int[] weights, String[] head2head) {
            int[] answer = new int[weights.length];
            PriorityQueue<Boxer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < weights.length; i++)
                queue.add(new Boxer(weights, head2head[i], i));

            for (int i = 0; i < weights.length; i++)
                answer[i] = queue.poll().number;

            return answer;
        }
    }

    public static class Boxer implements Comparable<Boxer> {
        private int number;
        private int weight;
        private double winRate;
        private int upperWinCnt;
        private int round;

        public Boxer(int[] weights, String head, int index) {
            this.number = index + 1;
            this.weight = weights[index];

            double winCnt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (head.charAt(i) == 'W') {
                    winCnt++;
                    round++;
                    if (weights[i] > weight)
                        upperWinCnt++;
                }
                else if(head.charAt(i) == 'L')
                    round++;
            }

            this.winRate = winCnt / round;
        }

        @Override
        public int compareTo(Boxer o) {
            if (this.winRate > o.winRate) return 1;
            else if (this.winRate < o.winRate) return -1;
            else {
                if (this.upperWinCnt > o.upperWinCnt) return 1;
                else if (this.upperWinCnt < o.upperWinCnt) return -1;
                else {
                    if (this.weight > o.weight) return 1;
                    else if (this.weight < o.weight) return -1;
                    else
                        return Integer.compare(o.number, this.number);
                }
            }
        }
    }
}
