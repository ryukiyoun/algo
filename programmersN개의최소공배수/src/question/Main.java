package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3}));
    }

    public static class Solution {
        public int solution(int[] arr) {
            int answer = arr[0];

            for (int i = 1; i < arr.length; i++) {
                answer = (answer * arr[i]) / GCD(answer, arr[i]);
            }

            return answer;
        }

        public int GCD(int number1, int number2){
            if(number1 < number2){
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }

            while(number2 != 0){
                int r = number1 % number2;
                number1 = number2;
                number2 = r;
            }

            return number1;
        }
    }
}
