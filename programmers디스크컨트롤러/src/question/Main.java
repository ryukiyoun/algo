package question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 5}, {2, 10}, {1000, 100}}));
    }

    public static class Solution {
        public int solution(int[][] jobs) {
            PriorityQueue<Work> startQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
            PriorityQueue<Work> timeQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
            for(int[] work : jobs) startQueue.offer(new Work(work[0], work[1]));

            int answer = 0;
            int startTime = startQueue.peek().start;
            while(!startQueue.isEmpty()){
                while(true){
                    if(!startQueue.isEmpty() && startTime >= startQueue.peek().start)
                        timeQueue.offer(startQueue.poll());
                    else
                        break;
                }

                if(!timeQueue.isEmpty()) {
                    Work task = timeQueue.poll();
                    answer += startTime + task.time - task.start;
                    startTime += task.time;
                }
                else{
                    Work task = startQueue.poll();
                    answer += task.time;
                    startTime = task.time + task.start;
                }

                while(!timeQueue.isEmpty())
                    startQueue.offer(timeQueue.poll());
            }

            return answer / jobs.length;
        }

        public static class Work{
            private final int start;
            private final int time;

            public Work(int start, int time){
                this.start = start;
                this.time = time;
            }
        }
    }
}
