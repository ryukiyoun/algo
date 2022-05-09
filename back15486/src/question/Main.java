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
        StringTokenizer stringTokenizer;
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 2];
        int[] arrT = new int[num + 2];
        int[] arrP = new int[num + 2];

        for (int i = 1; i <= num; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            arrT[i] = Integer.parseInt(stringTokenizer.nextToken());
            arrP[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = num; i > 0; i--) {
            if (i + arrT[i] <= num + 1)
                dp[i] = Math.max(dp[i + arrT[i]] + arrP[i], dp[i + 1]);
            else
                dp[i] = dp[i + 1];
        }

        bw.write(dp[1] + "\n");
        bw.flush();
    }
}
