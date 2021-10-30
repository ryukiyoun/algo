package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution("4177252841", 6));
    }

    public static class Solution {
        public String solution(String number, int k) {
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < number.length(); i++) {
                while (!stack.isEmpty()) {
                    if (Integer.parseInt(stack.peek()) < Integer.parseInt(number.substring(i, i + 1)) && k != 0) {
                        stack.pop();
                        k--;
                    } else
                        break;
                }

                stack.push(number.substring(i, i + 1));
            }

            for(int i=0; i<k; i++)
                stack.pop();

            StringBuilder stringBuilder = new StringBuilder();

            while(!stack.isEmpty())
                stringBuilder.append(stack.pop());

            return stringBuilder.reverse().toString();
        }
    }
}
