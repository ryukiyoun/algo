package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        solution.solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
    }

    public static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];

            Set<String> set = new HashSet<>();
            set.add(words[0]);

            for(int i=1; i<words.length; i++){
                if(words[i - 1].charAt(words[i - 1].length()-1) != words[i].charAt(0) || set.contains(words[i])){
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
                else
                    set.add(words[i]);
            }

            return answer;
        }
    }
}
