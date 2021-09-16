package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());

        BigDecimal[] dp = new BigDecimal[numCnt+1];
        Arrays.fill(dp, BigDecimal.ZERO);

        dp[1] = BigDecimal.valueOf(Double.parseDouble(br.readLine()));

        for(int i=2; i<=numCnt; i++) {
            BigDecimal num = BigDecimal.valueOf(Double.parseDouble(br.readLine()));
            dp[i] = dp[i-1].multiply(num).max(num);
        }

        Arrays.sort(dp);

        bw.write(dp[numCnt].setScale(3, RoundingMode.HALF_EVEN) + "\n");
        bw.flush();
    }
}
