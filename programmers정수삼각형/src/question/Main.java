package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int[][] temp = new int[triangle.length][triangle[triangle.length-1].length];
            temp[0][0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if(j == 0)
                        temp[i][j] = temp[i - 1][j] + triangle[i][j];
                    else if(i == j)
                        temp[i][j] = temp[i - 1][j - 1] + triangle[i][j];
                    else
                        temp[i][j] = Math.max(temp[i - 1][j - 1] + triangle[i][j], temp[i - 1][j] + triangle[i][j]);

                    answer = Math.max(answer, temp[i][j]);
                }
            }

            return answer;
        }
    }
}
