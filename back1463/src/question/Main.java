package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int questionNum = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=questionNum; i++){
            dp[i] = dp[i-1] + 1;

            int tmp3 = 0;
            int tmp2 = 0;

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
                tmp3 = dp[i];
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
                tmp2 = dp[i];
            }

            if(tmp3 != 0 && tmp2 != 0)
                dp[i] = Math.min(tmp3, tmp2);
        }

        bw.write(dp[questionNum] + "\n");
        bw.flush();
    }
}