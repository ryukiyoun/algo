package question;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    public static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                if (map.containsKey(clothes[i][1]))
                    map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                else
                    map.put(clothes[i][1], 1);
            }

            for(String key : map.keySet())
                answer *= map.get(key) + 1;
            return answer -1;
        }
    }
}
