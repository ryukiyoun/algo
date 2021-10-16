package question;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"119", "1193", "789"}));
    }

    public static class Solution {
        public boolean solution(String[] phone_book) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(String sub : phone_book) hashMap.put(sub, sub.length());

            for(int i=0; i< phone_book.length; i++){
                for(int j=1; j<phone_book[i].length(); j++){
                    if(hashMap.containsKey(phone_book[i].substring(0, j))){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
