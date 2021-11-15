package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }

    public static class Solution {
        public int[] solution(String s) {
            String[] groups = Pattern.compile("\\{(.*?)}")
                    .matcher(s.substring(1, s.length() - 1))
                    .results()
                    .map(MatchResult::group)
                    .toArray(String[]::new);

            Arrays.sort(groups, Comparator.comparingInt(String::length));

            List<Integer> answer = new ArrayList<>();
            for(String sub : groups){
                sub = sub.substring(1, sub.length() - 1);
                String[] numbers = sub.split(",");

                for(String number : numbers){
                    int num = Integer.parseInt(number);
                    if(!answer.contains(num))
                        answer.add(num);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
