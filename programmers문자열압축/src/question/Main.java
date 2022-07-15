package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("xababcdcdababcdcd"));
    }

    public static class Solution {
        public int solution(String s) {
            int answer = s.length();

            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder change = new StringBuilder();
                String startStr = "";
                int count = 1;

                startStr = s.substring(0, i);
                for (int j = i; j < s.length(); j += i) {
                    if (j + i <= s.length()) {
                        String substring = s.substring(j, i + j);

                        if (startStr.equals(substring)) {
                            count++;
                        } else {
                            if (count != 1) change.append(count);
                            change.append(startStr);
                            startStr = substring;
                            count = 1;
                        }
                    } else {
                        if (count != 1) change.append(count);
                        change.append(startStr);
                        change.append(s.substring(j));
                        startStr = "";
                        count = 1;
                    }
                }

                if (count != 1) change.append(count);
                change.append(startStr);

                answer = Math.min(answer, change.length());
            }

            return answer;
        }
    }
}
