package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
        //System.out.println(solution.solution(5));
    }

    public static class Solution {
        private int answer = 0;

        public int solution(int n) {
            int[] queen = new int[n];

            DFS(queen, n, 0);

            return answer;
        }

        public void DFS(int[] queen, int n, int yIndex) {
            if (n == yIndex)
                answer++;
            else {
                for (int i = 0; i < n; i++) {
                    if (check(queen, yIndex, i)) {
                        queen[yIndex] = i;
                        DFS(queen, n, yIndex + 1);
                    }
                }
            }
        }

        public boolean check(int[] queen, int yIndex, int x) {
            for (int i = 0; i < yIndex; i++) {
                if (queen[i] == x) return false;
                if (Math.abs(i - yIndex) == Math.abs(queen[i] - x)) return false;
            }

            return true;
        }
    }
}
