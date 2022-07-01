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

        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 1];

        dp[1] = Integer.parseInt(br.readLine().split(" ")[2]);

        for (int i = 2; i <= num; i++) {
            int input = Integer.parseInt(br.readLine().split(" ")[2]);
            int max = 0;

            for (int j = i - 2; j > -1; j--) {
                max = Math.max(max, dp[j]);
            }

            dp[i] = Math.max(max + input, dp[i-1]);
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
