package question;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    public static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Print> queue = new LinkedList<>();

            for(int i=0; i< priorities.length; i++)
                queue.add(new Print(priorities[i], i));

            while (!queue.isEmpty()){
                Print print = queue.poll();

                boolean isUpperPriority = false;
                for(Print sub : queue){
                    if(print.priority < sub.priority) {
                        isUpperPriority = true;
                        break;
                    }
                }

                if(isUpperPriority)
                    queue.add(print);
                else{
                    answer++;
                    if(print.location == location)
                        break;
                }
            }
            return answer;
        }

        public static class Print{
            private int priority;
            private int location;

            public Print(int priority, int location){
                this.priority = priority;
                this.location = location;
            }
        }
    }
}
