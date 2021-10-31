package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 7, 3));
    }

    public static class Solution {
        public int solution(int n, int a, int b) {
            int start = 1;
            int end = n;

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            while (true) {
                int middle = start + (end - start) / 2;

                if (a <= middle && b > middle)
                    return (int) logB(end - start + 1, 2);
                else if (a > middle && b > middle)
                    start = middle + 1;
                else if (a <= middle && b <= middle)
                    end = middle;
            }
        }

        public static double logB(double x, double base) {
            return Math.log(x) / Math.log(base);
        }
    }
}
