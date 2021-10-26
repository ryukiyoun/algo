package question;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
    }

    public static class Solution {
        public int solution(String s) {
            if ((s.length() & 1) == 1)
                return 0;
            else {
                Stack<String> stack = new Stack<>();
                stack.push(s.substring(0, 1));

                for (int i = 1; i < s.length(); i++) {
                    if (!stack.isEmpty() && stack.peek().equals(s.substring(i, i + 1))) stack.pop();
                    else
                        stack.push(s.substring(i, i + 1));
                }

                if (stack.isEmpty())
                    return 1;
                else
                    return 0;
            }
        }
    }
}
