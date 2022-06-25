package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        BigInteger[][] dp = new BigInteger[n+1][m+1];

        Arrays.fill(dp[1], BigInteger.ONE);

        for(int i=1; i<=n; i++)
            dp[i][1] = BigInteger.ONE;

        for(int i=2; i<=n; i++){
            for(int j=2; j<=m; j++)
                dp[i][j] = dp[i-1][j].add(dp[i-1][j-1]).add(dp[i][j-1]).mod(BigInteger.valueOf(1000000007));
        }

        bw.write(dp[n][m] + "\n");
        bw.flush();
    }
}
