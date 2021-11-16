package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));
    }

    public static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);

            Deque<Integer> deque = new LinkedList<>();
            for (int person : people) deque.offerLast(person);

            int answer = 0;
            while(deque.size() > 1){
                int front = deque.pollFirst();
                int back = deque.pollLast();

                if(front + back > limit)
                    deque.offerFirst(front);

                answer++;
            }

            if(!deque.isEmpty())
                answer++;

            return answer;
        }
    }
}
