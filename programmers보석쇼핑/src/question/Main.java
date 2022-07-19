package question;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        solution.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        solution.solution(new String[]{"XYZ", "XYZ", "XYZ"});
        solution.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        solution.solution(new String[]{"D", "AA", "AA", "D", "AA", "C", "B"});
    }

    public static class Solution {
        public int[] solution(String[] gems) {
            Set<String> gemCnt = new HashSet<>();
            Collections.addAll(gemCnt, gems);

            Queue<String> queue = new LinkedList<>();
            Map<String, Integer> count = new HashMap<>();

            int start = 0;
            int end = Integer.MAX_VALUE;
            int offset = 0;
            for (String gem : gems) {
                count.put(gem, count.getOrDefault(gem, 0) + 1);
                queue.add(gem);

                while (!queue.isEmpty()) {
                    String front = queue.peek();

                    if (count.get(front) > 1) {
                        offset++;
                        queue.poll();
                        count.put(front, count.get(front) - 1);
                    } else break;
                }

                if (gemCnt.size() == count.size() && end > queue.size()) {
                    start = offset;
                    end = queue.size();
                }
            }

            return new int[]{1 + start, start + end};
        }
    }
}
