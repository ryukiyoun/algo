package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int num = Integer.parseInt(br.readLine());

            if(num == 0) break;

            long[] dp = new long[num];
            dp[0] = Long.parseLong(br.readLine());

            for(int i=1; i<num; i++){
                long pay = Integer.parseInt(br.readLine());
                dp[i] = Math.max(pay, dp[i-1] + pay);
            }

            Arrays.sort(dp);

            bw.write(dp[num-1] + "\n");
            bw.flush();
        }
    }
}
