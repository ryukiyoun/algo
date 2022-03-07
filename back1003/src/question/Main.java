package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp = new int[2][41];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int num = Integer.parseInt(br.readLine());

            for(int j=2; j<=num; j++) {
                dp[0][j] = dp[0][j-1] + dp[0][j-2];
                dp[1][j] = dp[1][j-1] + dp[1][j-2];
            }

            bw.write(dp[0][num] + " " + dp[1][num] + "\n");
            bw.flush();
        }
    }
}
