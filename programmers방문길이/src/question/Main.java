package question;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("LULLLLLLUD"));
    }

    public static class Solution {
        public int solution(String dirs) {
            Map<String, Point> map = new HashMap<>();
            map.put("U", new Point(0, 1));
            map.put("D", new Point(0, -1));
            map.put("R", new Point(1, 0));
            map.put("L", new Point(-1, 0));

            Set<String> set = new HashSet<>();
            Point start = new Point(0, 0);

            for(String sub : dirs.split("")){
                Point move = map.get(sub);
                int calcX = start.x + move.x;
                int calcY = start.y + move.y;

                if(calcX >= -5 && calcX <= 5 && calcY >= -5 && calcY <= 5) {
                    StringBuilder go = new StringBuilder();
                    go.append(start.x);
                    go.append(start.y);
                    go.append(calcX);
                    go.append(calcY);

                    StringBuilder back = new StringBuilder();
                    back.append(calcX);
                    back.append(calcY);
                    back.append(start.x);
                    back.append(start.y);

                    if(!set.contains(go.toString()) && !set.contains(back.toString()))
                        set.add(go.toString());
                    start = new Point(calcX, calcY);
                }
            }

            return set.size();
        }
    }
}
