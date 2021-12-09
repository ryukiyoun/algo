package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    public static class Solution {
        private int answer = 0;

        public int solution(int n) {
            int[] map = new int[n];
            Backtrack(n, 0, map);
            return answer;
        }

        public void Backtrack(int n, int rowIndex, int[] map) {
            if (n == rowIndex) {
                answer++;
            } else {
                for (int i = 0; i < n; i++) {
                    map[rowIndex] = i;
                    if (check(map, rowIndex)) Backtrack(n, rowIndex + 1, map);
                }
            }
        }

        public boolean check(int[] map, int rowIndex) {
            for (int i = 0; i < rowIndex; i++) {
                if (map[i] == map[rowIndex]) return false;
                if (Math.abs(map[i] - map[rowIndex]) == Math.abs(i - rowIndex)) return false;
            }

            return true;
        }
    }
}
