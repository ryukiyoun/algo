package question;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 24));
    }

    public static class Solution {
        public String solution(int a, int b) {
            return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
        }
    }
}
