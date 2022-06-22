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

        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][num + 1];
        Arrays.fill(dp[1], 100000000);

        dp[0][1] = 0;
        dp[1][1] = 0;
        if (num > 1) {
            dp[0][2] = 1;
            dp[1][2] = 1;
        }
        if (num > 2) {
            dp[0][3] = 2;
            dp[1][3] = 2;
        }

        for (int i = 4; i <= num; i++) {
            for (int j = 2; j < i; j++) {
                if (i - j != 1) {
                    dp[0][i] = Math.max(dp[0][i], dp[0][j] + dp[0][i - j]);
                    dp[1][i] = Math.min(dp[1][i], dp[1][j] + dp[1][i - j]);
                }
            }
        }

        bw.write(dp[1][num] + " " + dp[0][num] + "\n");
        bw.flush();
    }
}
