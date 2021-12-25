package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(4, 10)));
        System.out.println(Arrays.toString(solution.solution(4, 20)));
        System.out.println(Arrays.toString(solution.solution(4, 5)));
        System.out.println(Arrays.toString(solution.solution(3, 6)));
        System.out.println(Arrays.toString(solution.solution(3, 3)));
    }

    public static class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];

            long start = k - 1;

            List<Integer> number = new ArrayList<>();

            for (int i = 0; i < n; i++)
                number.add(i + 1);

            long[] fac = new long[n + 1];

            fac[1] = 1;
            if (n > 1)
                fac[2] = 2;

            for (int i = 3; i < n + 1; i++)
                fac[i] = i * fac[i - 1];

            int i = 0;
            while (n > 2) {
                long index = start / fac[n - 1];

                answer[i] = number.get((int) index);
                number.remove((int) index);

                start -= fac[n-1] * index;

                i++;
                n--;
            }

            if (start % 2 == 1) {
                answer[i++] = number.get(1);
                answer[i] = number.get(0);
            }
            else{
                answer[i++] = number.get(0);
                answer[i] = number.get(1);
            }

            return answer;
        }
    }
}
