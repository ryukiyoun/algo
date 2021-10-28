package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(br.readLine()));
    }

    public static class Solution {
        private String[] num;
        private boolean[] visit;
        private List<Integer> set = new ArrayList<>();
        public int solution(String numbers) {
            num = numbers.split("");
            visit = new boolean[num.length];

            for(int i=0; i<num.length; i++){
                perm(i+1, 0, "");
            }

            eratos();


            return set.size();
        }

        public void perm(int pickCnt, int depth, String result){
            if(pickCnt == depth){
                if(!set.contains(Integer.parseInt(result)))
                    set.add(Integer.parseInt(result));
            }
            else{
                for(int i=0; i<num.length; i++){
                    if(!visit[i]){
                        visit[i] = true;
                        perm(pickCnt, depth+1, result + num[i]);
                        visit[i] = false;
                    }
                }
            }
        }

        public void eratos(){
            Integer max = Collections.max(set);
            set.remove((Object)0);
            set.remove((Object)1);

            boolean[] check = new boolean[max + 1];
            Arrays.fill(check, true);

            for(int i=2; (i*i)<=max; i++){
                if(check[i]){
                    for(int j = i*i; j<=max; j+=i) {
                        check[j] = false;
                        if(set.contains(j))
                            set.remove((Object)j);
                    }
                }
            }
        }
    }
}
