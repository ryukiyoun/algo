package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("ZZZZzzzz zzzzZZZZ", 4));
    }

    public static class Solution {
        public String solution(String s, int n) {
            StringBuilder stringBuilder = new StringBuilder();

            for(char subStr : s.toCharArray()){
                if(subStr == ' ')
                    stringBuilder.append(' ');
                else{
                    int charPoint = (int)subStr + n;
                    if(97 <= (int)subStr && (int)subStr <= 122){
                        if(charPoint > 122)
                            charPoint -= 26;

                        stringBuilder.append(Character.toString(charPoint));
                    }
                    else{
                        if(charPoint > 90)
                            charPoint -= 26;

                        stringBuilder.append(Character.toString(charPoint));
                    }
                }
            }

            return stringBuilder.toString();
        }
    }
}
