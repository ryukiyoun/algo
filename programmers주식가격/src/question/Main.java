package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 2, 3}));
    }

    public static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    answer[i]++;
                    if(prices[i] > prices[j])
                        break;
                }
            }

            return answer;
        }
    }
}
