package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28}));
    }

    public static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for(int i=0; i<n; i++){
                String arr1BitStr = Integer.toBinaryString(arr1[i]);
                StringBuilder arr1BitStrb = new StringBuilder(arr1BitStr);
                for(int j=arr1BitStr.length(); j<n; j++)
                    arr1BitStrb.insert(0,"0");

                String arr2BitStr = Integer.toBinaryString(arr2[i]);
                StringBuilder arr2BitStrb = new StringBuilder(arr2BitStr);
                for(int j=arr2BitStr.length(); j<n; j++)
                    arr2BitStrb.insert(0,"0");

                StringBuilder result = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(arr1BitStrb.charAt(j) == '0' && arr2BitStrb.charAt(j) == '0')
                        result.append(' ');
                    else
                        result.append('#');
                }

                answer[i] = result.toString();
            }
            return answer;
        }
    }
}
