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

        int num = Integer.parseInt(br.readLine());

        BigInteger[][] dp = new BigInteger[num+1][num+1];

        for(int i=1; i<=num; i++)
            Arrays.fill(dp[i], BigInteger.ZERO);

        dp[1][1] = BigInteger.ONE;

        for(int i=1; i<=num; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=1; j<=num; j++){
                int jumpAble = Integer.parseInt(stringTokenizer.nextToken());

                if(dp[i][j].compareTo(BigInteger.ZERO) > 0 && jumpAble != 0) {
                    if (j + jumpAble <= num) {
                        dp[i][j + jumpAble] = dp[i][j].add(dp[i][j + jumpAble]);
                    }
                    if (i + jumpAble <= num) {
                        dp[i + jumpAble][j] = dp[i][j].add(dp[i + jumpAble][j]);
                    }
                }
            }
        }

        bw.write(dp[num][num].toString() + "\n");
        bw.flush();
    }
}
