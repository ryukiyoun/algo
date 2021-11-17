package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution("()))((()"));
    }

    public static class Solution {
        public String solution(String p) {
            return splitStr(p);
        }

        public String splitStr(String str) {
            if (str.equals("")) return "";

            int count = 0, index = 0;

            for (int i = 0; i < str.length(); i++) {
                count += str.charAt(i) == '(' ? 1 : -1;

                if (count == 0) {
                    index = i;
                    break;
                }
            }

            String u = str.substring(0, index + 1);
            String v = str.substring(index + 1);

            if (check(u))
                return u + splitStr(v);
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                sb.append(splitStr(v));
                sb.append(")");

                String changeU = u.substring(1, u.length() - 1).replace("(", "t").replace(")", "(").replace("t", ")");

                sb.append(changeU);

                return sb.toString();
            }
        }

        public boolean check(String str) {
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                count += str.charAt(i) == '(' ? 1 : -1;

                if (count < 0) return false;
            }

            return true;
        }
    }
}
