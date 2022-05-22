package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[Integer.parseInt(br.readLine())];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        dp[0] = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=1; i<dp.length; i++)
            dp[i] = Math.max(dp[i - 1], 0) + Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(dp);

        bw.write(dp[dp.length-1] + "\n");
        bw.flush();
    }
}
