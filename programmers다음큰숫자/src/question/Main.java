package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        System.out.println(solution.solution(Integer.parseInt(br.readLine())));
    }

    public static class Solution {
        public int solution(int n) {
            StringBuilder number = new StringBuilder(Integer.toBinaryString(n)).reverse().append('0');

            int mOneCnt = 0;
            int oneIndex = -1;
            for(int i=0; i<number.length()-1; i++){
                if(number.charAt(i) == '1'){
                    mOneCnt++;
                    if(number.charAt(i+1) == '0') {
                        oneIndex = i;
                        break;
                    }
                }
            }

            if ((n & 1) == 1) {
                n -= (int) Math.pow(2, oneIndex);
                n += (int) Math.pow(2, oneIndex + 1);
            }
            else{
                n -= (int) Math.pow(2, oneIndex);

                if(mOneCnt >= 2){
                    n -= (int) Math.pow(2, oneIndex - 1);
                    n += (int) Math.pow(2, oneIndex + 1);
                    n++;
                }
                else{
                    n += (int) Math.pow(2, oneIndex + 1);
                }
            }

            return n;
        }
    }
}
