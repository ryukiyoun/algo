package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}));
        //System.out.println(solution.solution(new String[]{"java backend junior pizza 150"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}));
    }

    public static class Solution {
        Map<String, List<Integer>> map;
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            map = new HashMap<>();

            for(String sub : info)
                Combination("", 0, 4, sub.split(" "));

            for(String key : map.keySet())
                Collections.sort(map.get(key));

            for(int i=0; i< query.length; i++){
                String q = query[i].replace(" and ", "");
                String[] qAndScore = q.split(" ");
                int upperScore = Integer.parseInt(qAndScore[1]);

                List<Integer> score = map.getOrDefault(qAndScore[0], new ArrayList<>());

                int start = 0;
                int end = score.size();

                while(start < end){
                    int mid = (start + end) / 2;

                    if(score.get(mid) < upperScore)
                        start = mid + 1;
                    else
                        end = mid;
                }

                answer[i] = score.size() - start;
            }

            return answer;
        }

        public void Combination(String str, int startDepth, int endDepth, String[] info){
            if(startDepth == endDepth){
                if(map.containsKey(str))
                    map.get(str).add(Integer.parseInt(info[4]));
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(Integer.parseInt(info[4]));
                    map.put(str, list);
                }
            }
            else{
                Combination(str+"-", startDepth + 1, endDepth, info);
                Combination(str+info[startDepth], startDepth + 1, endDepth, info);
            }
        }
    }
}
