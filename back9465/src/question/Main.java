package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizerIndex0;
        StringTokenizer stringTokenizerIndex1;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int num = Integer.parseInt(br.readLine());

            stringTokenizerIndex0 = new StringTokenizer(br.readLine());
            stringTokenizerIndex1 = new StringTokenizer(br.readLine());

            long[][] dp = new long[2][num+1];

            dp[0][1] = Long.parseLong(stringTokenizerIndex0.nextToken());
            dp[1][1] = Long.parseLong(stringTokenizerIndex1.nextToken());

            for(int j=2; j<=num; j++){
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + Long.parseLong(stringTokenizerIndex0.nextToken());
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + Long.parseLong(stringTokenizerIndex1.nextToken());
            }

            bw.write(Math.max(dp[0][num], dp[1][num]) + "\n");
            bw.flush();
        }
    }
}
