package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(24, 27));
    }

    public static class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i = left; i <= right; i++) {
                int divisorCnt = 0;
                for (int j = 1; j <= i; j++) {
                    if (j > i / j)
                        break;
                    if (i % j == 0) {
                        if (j == i / j) {
                            divisorCnt++;
                            break;
                        }
                        divisorCnt += 2;
                    }
                }

                if ((divisorCnt & 1) == 1)
                    answer -= i;
                else
                    answer += i;
            }

            return answer;
        }
    }
}
