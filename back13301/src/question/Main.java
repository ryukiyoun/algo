package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[num+1];

        if(num>0)
            dp[1] = BigInteger.valueOf(4);
        if(num>1)
            dp[2] = BigInteger.valueOf(6);

        for(int i=3; i<=num; i++)
            dp[i] = dp[i-2].add(dp[i-1]);

        bw.write(dp[num].toString() + "\n");
        bw.flush();
    }
}
