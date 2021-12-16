package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("abacde"));
    }

    public static class Solution {
        public int solution(String s) {
            int strLength = s.length() - 1;

            for (int l = strLength; l > -1; l--) {
                for (int si = 0; si + l <= strLength; si++) {
                    boolean isPel = true;

                    int front = si;
                    int back = si + l;

                    while(front < back){
                        if(s.charAt(front) != s.charAt(back)){
                            isPel = false;
                            break;
                        }

                        front++;
                        back--;
                    }
                    if(isPel)
                        return l + 1;
                }
            }

            return 0;
        }
    }
}
