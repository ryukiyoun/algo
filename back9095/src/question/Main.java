package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[11];

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){

            int num = Integer.parseInt(br.readLine());

            for(int j=4; j<=num; j++)
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];

            bw.write(dp[num] + "\n");
            bw.flush();
        }
    }
}
