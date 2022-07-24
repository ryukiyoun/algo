package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(7));
    }

    public static class Solution {
        public int solution(int n) {
            int count = 0;
            for(int i=1; i<=n; i++){
                int answer = 0;
                for(int j=i; j<=n; j++){
                    answer += j;
                    if(answer > n)
                        break;
                    else if(answer == n) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    }
}
