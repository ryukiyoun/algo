package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution("abcccc", "cccefggg"));
    }

    public static class Solution {
        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            makeMap(str1);
            makeMap(str2);

            return calc(makeMap(str1), makeMap(str2));
        }

        public Map<String, Integer> makeMap(String str) {
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < str.length() - 1; i++) {
                String subStr = str.substring(i, i + 2);
                if (isAlpha(subStr)) {
                    if (map.containsKey(subStr))
                        map.put(subStr, map.get(subStr) + 1);
                    else
                        map.put(subStr, 1);
                }
            }

            return map;
        }

        public int calc(Map<String, Integer> map1, Map<String, Integer> map2) {
            double numerator = 0;
            double denominator = 0;

            if(map1.size() == 0 && map2.size() == 0)
                return 65536;

            Set<String> keys = new HashSet<>(map1.keySet());

            for (String key : keys) {
                if (map2.containsKey(key)) {
                    numerator += Math.min(map1.get(key), map2.get(key));
                    denominator += Math.max(map1.get(key), map2.get(key));
                    map1.remove(key);
                    map2.remove(key);
                }
            }

            for(String key : map1.keySet())
                denominator += map1.get(key);

            for(String key : map2.keySet())
                denominator += map2.get(key);

            return (int)Math.floor(numerator / denominator * 65536);
        }

        public boolean isAlpha(String str) {
            if (97 <= str.charAt(0) && str.charAt(0) <= 122) {
                return 97 <= str.charAt(1) && str.charAt(1) <= 122;
            }

            return false;
        }
    }
}
