package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackJun11051 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer strToken;
        strToken = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(strToken.nextToken());
        int k = Integer.parseInt(strToken.nextToken());

        long[][] dp = new long[n+1][1001];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

        bw.write(dp[n][k] % 10007 + "\n");
        bw.flush();
    }
}
