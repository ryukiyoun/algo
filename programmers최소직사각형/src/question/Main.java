package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
    }

    public static class Solution {
        public int solution(int[][] sizes) {
            int maxX = sizes[0][0];
            int maxY = sizes[0][1];

            for(int i=1; i<sizes.length; i++){
                if(sizes[i][0] > maxX || sizes[i][1] > maxY){
                    int size = Math.max(maxX, sizes[i][0]) * Math.max(maxY, sizes[i][1]);
                    int revertSize = Math.max(maxX, sizes[i][1]) * Math.max(maxY, sizes[i][0]);

                    if(size > revertSize) {
                        maxX = Math.max(maxX, sizes[i][1]);
                        maxY = Math.max(maxY, sizes[i][0]);
                    }
                    else{
                        maxX = Math.max(maxX, sizes[i][0]);
                        maxY = Math.max(maxY, sizes[i][1]);
                    }
                }
            }

            return maxX * maxY;
        }
    }
}
