package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static class Solution {
        private int answer = 0;
        private int[] numbers;
        public int solution(int[] numbers, int target) {
            this.numbers = numbers;
            DFS(0, numbers.length - 1, numbers[0], target);
            DFS(0, numbers.length - 1, numbers[0] * -1, target);
            return answer;
        }

        public void DFS(int nowDepth, int targetDepth, int nowNumber, int targetNumber) {
            if (nowDepth == targetDepth) {
                if (nowNumber == targetNumber)
                    answer++;
            } else {
                DFS(nowDepth + 1, targetDepth, nowNumber + numbers[nowDepth + 1], targetNumber);
                DFS(nowDepth + 1, targetDepth, nowNumber - numbers[nowDepth + 1], targetNumber);
            }
        }
    }
}
