package question;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {0, 0, 0, 0}));
    }

    public static class Solution {
        public String solution(int[] numbers) {
            PriorityQueue<Number> queue = new PriorityQueue<>();

            for (int number : numbers) queue.add(new Number(number));

            StringBuilder result = new StringBuilder();

            while(!queue.isEmpty())
                result.append(queue.poll().origin);

            return result.toString().replaceFirst("^0+(?!$)", "");
        }

        public static class Number implements Comparable<Number>{
            private int origin;
            private StringBuilder convertNum;

            public Number(int num){
                this.origin = num;

                convertNum = new StringBuilder();
                for(int i=0; i<4; i++){
                    convertNum.append(Integer.toString(origin).charAt(i%Integer.toString(origin).length()));
                }
            }

            @Override
            public int compareTo(Number o) {
                return Integer.compare(Integer.parseInt(o.convertNum.toString()), Integer.parseInt(this.convertNum.toString()));
            }
        }
    }
}
