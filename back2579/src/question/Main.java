package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];

        int postNum = 0;
        int nowNum;
        dp[1] = Integer.parseInt(br.readLine());
        if (num > 1) {
            postNum = Integer.parseInt(br.readLine());
            dp[2] = dp[1] + postNum;
        }

        for (int i = 3; i <=num; i++) {
            nowNum = Integer.parseInt(br.readLine());
            dp[i] = Math.max(dp[i - 2] + nowNum, dp[i - 3] + postNum + nowNum);
            postNum = nowNum;
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
