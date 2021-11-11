package question;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solution(5);
    }

    public static class Solution {
        public int[] solution(int n) {
            int[][] arr = new int[n][n];
            int x = 0, y = -1, p = n, num = 1;

            while(true){
                for(int i=0; i<p; i++)
                    arr[++y][x] = num++;

                if(--p == 0) break;

                for(int i=0; i<p; i++)
                    arr[y][++x] = num++;

                if(--p == 0) break;

                for(int i=0; i<p; i++)
                    arr[--y][--x] = num++;

                if(--p == 0) break;
            }

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<i+1; j++)
                    list.add(arr[i][j]);
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
