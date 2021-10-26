package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(String sub : skill_trees){
                int preIndex = sub.indexOf(skill.charAt(0));

                boolean isPerfect = true;
                for(int i=1; i<skill.length(); i++){
                    int nowIndex = sub.indexOf(skill.charAt(i));

                    if(preIndex == -1 && nowIndex != -1) {
                        isPerfect = false;
                        break;
                    }

                    if(preIndex != -1 && nowIndex == -1) {
                        preIndex = nowIndex;
                        continue;
                    }
                    if(preIndex > nowIndex) {
                        isPerfect = false;
                        break;
                    }

                    preIndex = nowIndex;
                }

                if(isPerfect)
                    answer++;
            }

            return answer;
        }
    }
}
