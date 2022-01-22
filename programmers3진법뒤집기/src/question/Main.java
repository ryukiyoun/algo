package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(45));
    }

    public static class Solution {
        public int solution(int n) {
            StringBuilder threeNumber = new StringBuilder();
            while(n > 0){
                threeNumber.append(n % 3);
                n /= 3;
            }
            return Integer.parseInt(threeNumber.toString(), 3);
        }
    }
}
