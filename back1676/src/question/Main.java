package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[num+1];
        dp[0] = BigInteger.ONE;
        if(num > 0)
        dp[1] = BigInteger.ONE;

        for(int i=2; i<=num; i++)
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));

        int result = 0;

        while(dp[num].mod(BigInteger.valueOf(10)).compareTo(BigInteger.ZERO) == 0) {
            dp[num] = dp[num].divide(BigInteger.valueOf(10));
            result++;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
