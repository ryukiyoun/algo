package question;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {3, 20, 4}));
    }

    public static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            for(int i=0; i<citations.length; i++){
                if(citations.length - i <= citations[i])
                    return citations.length - i;
            }

            return 0;
        }
    }
}
