package question;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(")))))))))))))"));
    }

    public static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            int remainderCloseCnt = 0;
            for(char sub : s.toCharArray()){
                if(sub == '(')
                    stack.push(sub);
                else {
                    remainderCloseCnt++;
                    if (!stack.isEmpty() && sub == ')'){
                        remainderCloseCnt--;
                        stack.pop();
                    }
                }
            }

            if(remainderCloseCnt != 0)
                return false;

            return stack.isEmpty();
        }
    }
}
