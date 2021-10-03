package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int questionNum = Integer.parseInt(br.readLine());

        Num[] dp = new Num[1000001];

        dp[1] = new Num(0, Arrays.asList(1));
        dp[2] = new Num(1, Arrays.asList(1, 2));
        dp[3] = new Num(1, Arrays.asList(1, 3));

        for(int i=4; i<=questionNum; i++){
            dp[i] = new Num();
            int tmp3 = 0, tmp2 = 0;
            List<Integer> tmp2List = new ArrayList<>();
            List<Integer> tmp3List = new ArrayList<>();

            dp[i].count = dp[i - 1].count + 1;

            if (i % 3 == 0) {
                if(dp[i - 1].count + 1 > dp[i / 3].count + 1){
                    dp[i].count = dp[i / 3].count + 1;
                    tmp3List.addAll(dp[i / 3].history);
                }
                else{
                    dp[i].count = dp[i - 1].count + 1;
                    tmp3List.addAll(dp[i - 1].history);
                }

                tmp3 = dp[i].count;
                dp[i].history = tmp3List;
            }
            if (i % 2 == 0) {
                if(dp[i - 1].count + 1 > dp[i / 2].count + 1){
                    dp[i].count = dp[i / 2].count + 1;
                    tmp2List.addAll(dp[i / 2].history);
                }
                else {
                    dp[i].count = dp[i - 1].count + 1;
                    tmp2List.addAll(dp[i - 1].history);
                }

                tmp2 = dp[i].count;
                dp[i].history = tmp2List;
            }

            if (tmp3 != 0 && tmp2 != 0) {
                if(tmp3 > tmp2){
                    dp[i].count = tmp2;
                    dp[i].history = tmp2List;
                }
                else{
                    dp[i].count = tmp3;
                    dp[i].history = tmp3List;
                }
            }
            else if(tmp3 == 0 && tmp2 == 0){
                dp[i].history.addAll(dp[i - 1].history);
            }

            dp[i].history.add(i);
        }

        Collections.reverse(dp[questionNum].history);

        final String result = dp[questionNum].history.stream().map(String::valueOf).collect(Collectors.joining(" "));

        bw.write(dp[questionNum].count + "\n");
        bw.write(result + "\n");
        bw.flush();
    }
    public static class Num{
        public int count = 0;
        public List<Integer> history = new ArrayList<>();

        public Num(){}

        public Num(int count, List<Integer> history){
            this.count = count;
            this.history = history;
        }
    }
}
