package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(5000));
    }

    public static class Solution {
        public int solution(int n) {
            int calc = n, answer = 1;

            while(calc > 2){
                calc /= 2;

                if((calc & 1) == 1) {
                    calc--;
                    answer++;
                }
            }

            return answer;
        }
    }
}
