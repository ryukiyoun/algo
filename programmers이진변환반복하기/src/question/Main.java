package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] tmp = solution.solution("1111111");
        System.out.println(tmp[0] + " " + tmp[1]);
    }

    public static class Solution {
        private int convertCount = 0;
        private int zeroCount = 0;

        public int[] solution(String s) {
            recur(s);
            return new int[]{convertCount, zeroCount};
        }

        public void recur(String num){
            if(!num.equals("1")) {
                convertCount++;

                int oneCnt = 0;
                for(char sub : num.toCharArray()){
                    if(sub == '1')
                        oneCnt++;
                }

                zeroCount += num.length() - oneCnt;

                recur(Integer.toBinaryString(oneCnt));
            }
        }
    }
}
