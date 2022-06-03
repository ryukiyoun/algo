package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        long[] dp = new long[68];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<68; i++)
            dp[i] = dp[i-4] + dp[i-3] + dp[i-2] + dp[i-1];

        for(int i=0; i<testCase; i++){
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
    }
}
