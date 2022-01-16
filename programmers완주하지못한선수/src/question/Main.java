package question;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    }

    public static class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> participantMap = new HashMap<>();

            for(String person : participant){
                if(participantMap.containsKey(person))
                    participantMap.put(person, participantMap.get(person) + 1);
                else
                    participantMap.put(person, 1);
            }

            for(String person : completion){
                if(participantMap.containsKey(person))
                    participantMap.put(person, participantMap.get(person) - 1);
            }

            for(String person : participant){
                if(participantMap.get(person) >= 1)
                    return person;
            }

            return null;
        }
    }
}
