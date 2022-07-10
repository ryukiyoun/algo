package question;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }

    public static class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

            int answer = 1;
            int left = routes[0][0];
            int right = routes[0][1];

            for(int i=1; i<routes.length; i++){
                if(left > routes[i][1] || right < routes[i][0]) {
                    left = routes[i][0];
                    right = routes[i][1];
                    answer++;
                }
                else {
                    left = Math.max(left, routes[i][0]);
                    right = Math.min(right, routes[i][1]);
                }
            }

            return answer;
        }
    }
}
