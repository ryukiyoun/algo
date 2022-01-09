package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution("EIO"));
    }

    public static class Solution {
        private List<String> list;
        private String[] spellings = new String[]{"A", "E", "I", "O", "U"};

        public int solution(String word) {
            answerRecur(word);

            return answerNumberOfCases(word);
        }

        public int answerRecur(String word) {
            list = new ArrayList<>();

            for (int i = 0; i < spellings.length; i++)
                recur(spellings[i]);

            Collections.sort(list);

            return list.indexOf(word) + 1;
        }

        public void recur(String result) {
            list.add(result);

            if (result.length() == 5)
                return;

            for (int i = 0; i < spellings.length; i++)
                recur(result + spellings[i]);
        }

        public int answerNumberOfCases(String word) {
            int numTerm = 781;
            int answer = 0;

            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 5; j++) {
                    if (spellings[j].equals(Character.toString(word.charAt(i)))) {
                        answer += j * numTerm + 1;
                        numTerm = numTerm / 5;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
