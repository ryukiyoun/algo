package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];

        dp[1] = 0;
        if(num>1)
            dp[2] = 1;

        for(int i=3; i<=num; i++) {
            double divide = (double)i / 2;
            if((i & 1) == 0)
                dp[i] = (int)Math.pow(divide, 2) + dp[(int)divide] * 2;
            else
                dp[i] = (int)(Math.ceil(divide) * Math.floor(divide)) + dp[(int)Math.ceil(divide)] + dp[(int)Math.floor(divide)];
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
