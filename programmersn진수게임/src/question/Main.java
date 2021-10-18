package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(16,	1000,	100,	100));
    }

    public static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();

            StringBuilder nNumberList = new StringBuilder("0");
            for (int i = 1; i < m * t; i++) {
                int calc = i;
                StringBuilder nNumber = new StringBuilder();
                while (calc > 0) {
                    if(calc % n < 10)
                        nNumber.append(calc % n);
                    else
                        nNumber.append((char)(calc % n + 55));
                    calc /= n;
                }
                nNumberList.append(nNumber.reverse());
            }

            for (int i = 0; i <= t; i++)
                answer.append(nNumberList.charAt((p - 1) + (i * m)));

            return answer.toString();
        }
    }
}
