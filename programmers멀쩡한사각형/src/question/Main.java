package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(12, 8));
    }

    public static class Solution {
        public long solution(int w, int h) {
            return w * h - (w + h - gcd(w, h));
        }

        public long gcd(int a, int b){

            while(b != 0){
                int r = a % b;
                a = b;
                b = r;
            }

            return a;
        }
    }
}
