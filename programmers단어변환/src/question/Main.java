package question;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public static class Solution {
        private String[] words;
        private int answer = Integer.MAX_VALUE;
        public int solution(String begin, String target, String[] words) {
            this.words = words;
            boolean[] check = new boolean[words.length];
            BFS(begin, target, 0, check);

            if(answer == Integer.MAX_VALUE)
                return 0;

            return answer;
        }

        public void BFS(String begin, String target, int result, boolean[] check){
            if(begin.equals(target))
                answer = Math.min(answer, result);
            else{
                for(int i=0; i< words.length; i++){
                    if(!check[i] && defCharterCount(begin, words[i]) == 1) {
                        check[i] = true;
                        BFS(words[i], target, result + 1, check);
                        check[i] = false;
                    }
                }
            }
        }

        public int defCharterCount(String begin, String sub){
            int count = 0;

            for(int i=0; i<sub.length(); i++){
                if(begin.charAt(i) != sub.charAt(i))
                    count++;
            }

            return count;
        }
    }
}
