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

        String input = "";
        while((input = br.readLine()) != null){
            int num = Integer.parseInt(input);
            BigInteger[] dp = new BigInteger[num + 1];
            dp[0] = BigInteger.ONE;

            if(num > 0)
                dp[1] = BigInteger.ONE;
            if(num > 1)
                dp[2] = BigInteger.valueOf(3);

            for(int i=3; i<=num; i++)
                dp[i] = dp[i-2].multiply(BigInteger.valueOf(2)).add(dp[i-1]);

            bw.write(dp[num] + "\n");
            bw.flush();
        }
    }
}
