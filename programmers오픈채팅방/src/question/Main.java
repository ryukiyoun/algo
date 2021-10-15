package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public static class Solution {
        public String[] solution(String[] record) {
            Map<String, String> user = new HashMap<>();
            List<Boolean> inoutCheck = new ArrayList<>();
            List<String> userIdCheck = new ArrayList<>();

            for (String str : record) {
                String[] chat = str.split(" ");

                if (chat[0].equals("Change"))
                    user.put(chat[1], chat[2]);
                else if (chat[0].equals("Enter")) {
                    user.put(chat[1], chat[2]);
                    inoutCheck.add(true);
                    userIdCheck.add(chat[1]);
                } else {
                    inoutCheck.add(false);
                    userIdCheck.add(chat[1]);
                }
            }

            String[] answer = new String[userIdCheck.size()];
            for(int i=0; i< userIdCheck.size(); i++){
                if(inoutCheck.get(i))
                    answer[i] = user.get(userIdCheck.get(i)) + "님이 들어왔습니다.";
                else
                    answer[i] = user.get(userIdCheck.get(i)) + "님이 나갔습니다.";
            }

            return answer;
        }
    }
}
