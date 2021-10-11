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
                for(char sub : num.toCharArray()){
                    if(sub == '0')
                        zeroCount++;
                }

                num = num.replaceAll("0", "");

                int current = num.length();
                StringBuilder stringBuilder = new StringBuilder();

                while(current > 0){
                    stringBuilder.append(current % 2);
                    current /= 2;
                }

                recur(stringBuilder.toString());
            }
        }
    }
}
