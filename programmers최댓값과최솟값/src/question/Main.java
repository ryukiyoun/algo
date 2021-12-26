package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("1 2 3 4"));
    }

    public static class Solution {
        public String solution(String s) {
            int[] numbersInt = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            return String.format("%s %s", numbersInt[0], numbersInt[numbersInt.length - 1]);
        }
    }
}
