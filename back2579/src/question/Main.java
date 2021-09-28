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
        int[] arr = new int[num + 1];

        for (int i = 1; i <= num; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];
        if (num > 1)
            dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= num; i++)
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
