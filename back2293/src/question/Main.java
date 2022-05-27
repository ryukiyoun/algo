package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int coinNum = Integer.parseInt(stringTokenizer.nextToken());
        int pay = Integer.parseInt(stringTokenizer.nextToken());

        int[] coins = new int[coinNum];
        int[] dp = new int[pay + 1];

        dp[0] = 1;

        for (int i = 0; i < coinNum; i++)
            coins[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < coinNum; i++) {
            for (int j = 1; j <= pay; j++) {
                if (coins[i] <= j)
                    dp[j] += dp[j - coins[i]];
            }
        }

        bw.write(dp[pay] + "\n");
        bw.flush();
    }
}
