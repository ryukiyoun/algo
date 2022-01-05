package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        for (int i = 1; i < 334; i++)
            System.out.println(i + "      " + solution.solution(i));
    }

    public static class Solution {
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();

            while (n > 0) {
                answer.insert(0, n % 3 == 0 ? 4 : n % 3);
                if (n % 3 == 0)
                    n = n / 3 - 1;
                else
                    n = n / 3;
            }

            return answer.toString();
        }
    }
}
