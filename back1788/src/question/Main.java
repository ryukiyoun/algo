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
        int absNum = Math.abs(num);

        BigInteger[] dp = new BigInteger[absNum + 1];
        dp[0] = BigInteger.ZERO;

        if (absNum > 0)
            dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= absNum; i++)
                dp[i] = dp[i - 1].add(dp[i - 2]).mod(BigInteger.valueOf(1000000000));

        if(num > 0)
            bw.write("1\n");
        else if(num == 0)
            bw.write("0\n");
        else{
            if((absNum & 1) == 1)
                bw.write("1\n");
            else
                bw.write("-1\n");
        }

        bw.write(dp[absNum].toString() + "\n");
        bw.flush();
    }
}
