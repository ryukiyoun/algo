package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num + 1];

        dp[1] = Integer.parseInt(br.readLine());

        int postNum = 0;
        if(num > 1) {
            postNum = Integer.parseInt(br.readLine());
            dp[2] = dp[1] + postNum;
        }

        for(int i=3; i<=num; i++){
            int nowNum = Integer.parseInt(br.readLine());
            dp[i] = Math.max(Math.max(dp[i-3] + postNum + nowNum, dp[i-2] + nowNum), dp[i-1]);
            postNum = nowNum;
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
