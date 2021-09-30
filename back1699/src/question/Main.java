package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//todo : 속도 개선이 필요함
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];

        Arrays.fill(dp, 2);

        dp[1] = 1;

        for(int i=2; i<=num; i++){
            dp[i] = dp[1] + dp[i-1];

            for(int j=2; j<=i/2; j++){
                dp[i] = Math.min(dp[j] + dp[i-j], dp[i]);
            }

            double sqrt = Math.sqrt(i);
            if(sqrt - (int)sqrt == 0.0)
                dp[i] = 1;
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
