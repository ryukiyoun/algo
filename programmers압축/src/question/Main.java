package question;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    public static class Solution {
        public int[] solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            List<String> dictionary = new ArrayList<>();
            for(int i=0; i<26; i++)
                dictionary.add(String.valueOf((char)(i + 65)));

            while(!msg.equals("")){
                for(int i=dictionary.size()-1; i > -1; i--){
                    if(msg.indexOf(dictionary.get(i)) == 0){
                        if(msg.length() > 1) {
                            msg = msg.substring(dictionary.get(i).length());
                            if(!msg.equals(""))
                                dictionary.add(dictionary.get(i) + msg.charAt(0));
                            answer.add(i + 1);
                            break;
                        }
                        else{
                            msg = "";
                            answer.add(i + 1);
                        }
                    }
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
