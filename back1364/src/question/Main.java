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
        int[] dp = new int[num + 1];

        for(int i=1; i<=num; i++) {
            if(i > 7)
                dp[i] = dp[i-1] + 2;
            else {
                if(i == 6 || i == 7)
                    dp[i] = i +1;
                else
                    dp[i] = i;
            }
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
