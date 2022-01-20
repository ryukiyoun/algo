package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static class Solution {
        private List<String> list;
        private Set<String> set;

        public int solution(String[] user_id, String[] banned_id) {
            list = new ArrayList<>();
            set = new HashSet<>();

            boolean[] check = new boolean[user_id.length];

            permutation(0, banned_id.length, check, user_id, "");

            checking(banned_id);

            return set.size();
        }

        public void permutation(int startDepth, int destDepth, boolean[] check, String[] user_id, String result) {
            if (startDepth == destDepth) {
                list.add(result.substring(0, result.length() - 1));
            } else {
                for (int i = 0; i < user_id.length; i++) {
                    if (!check[i]) {
                        check[i] = true;
                        permutation(startDepth + 1, destDepth, check, user_id, result + user_id[i] + ",");
                        check[i] = false;
                    }
                }
            }
        }

        public void checking(String[] banned_id) {
            for(String sub : list){
                String[] split = sub.split(",");
                boolean[] check = new boolean[split.length];

                int count = 0;
                for(int i=0; i< banned_id.length; i++){
                    String reg = banned_id[i].replace("*", "[\\w]");
                    for(int j=0; j<split.length; j++) {
                        if (!check[j] && Pattern.matches(reg, split[j])) {
                            check[j] = true;
                            count++;
                            break;
                        }
                    }
                }

                if(count == banned_id.length){
                    Arrays.sort(split);
                    set.add(String.join(",", split));
                }
            }
        }
    }
}
