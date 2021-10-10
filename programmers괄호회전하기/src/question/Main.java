package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(br.readLine()));
    }

    public static class Solution {
        public int solution(String s) {
            int answer = 0;
            StringBuilder stringBuilder = new StringBuilder(s);

            if((stringBuilder.length() & 1) == 1)
                return 0;

            int close = 0;
            for(char sub : stringBuilder.toString().toCharArray()){
                if(sub == ')' || sub == '}' || sub == ']')
                    close++;
            }

            if(close == stringBuilder.length())
                return 0;

            for(int i=0 ;i<s.length(); i++){
                Stack<Character> stack = new Stack<>();

                for(int j=0; j<stringBuilder.length(); j++){
                    switch (stringBuilder.charAt(j)){
                        case ')' :
                            if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                            break;
                        case '}' :
                            if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                            break;
                        case ']' :
                            if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                            break;
                        default:
                            stack.push(stringBuilder.charAt(j));
                    }
                }

                if(stack.isEmpty())
                    answer++;

                stringBuilder.append(stringBuilder.charAt(0));
                stringBuilder.deleteCharAt(0);
            }

            return answer;
        }
    }
}
