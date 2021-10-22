package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
    }

    public static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++)
                queue.add((int)Math.ceil((100d - progresses[i]) / speeds[i]));

            while(!queue.isEmpty()){
                int count = 1;
                int pre = queue.poll();

                while(!queue.isEmpty()){
                    if(pre >= queue.peek()){
                        count++;
                        queue.poll();
                    }
                    else
                        break;
                }

                answer.add(count);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
