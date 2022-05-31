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

        int num;
        int caseNum = 1;

        while((num=Integer.parseInt(br.readLine())) != 0){
            long[][] dp = new long[num][3];

            stringTokenizer = new StringTokenizer(br.readLine());

            dp[0][0] = Integer.parseInt(stringTokenizer.nextToken());
            dp[0][1] = Integer.parseInt(stringTokenizer.nextToken());
            dp[0][2] = Integer.parseInt(stringTokenizer.nextToken());

            dp[0][2] += dp[0][1];

            stringTokenizer = new StringTokenizer(br.readLine());

            dp[1][0] = dp[0][1] + Integer.parseInt(stringTokenizer.nextToken());
            dp[1][1] = Math.min(Math.min(dp[1][0], dp[0][1]), dp[0][2]) + Integer.parseInt(stringTokenizer.nextToken());
            dp[1][2] = Math.min(Math.min(dp[1][1], dp[0][1]), dp[0][2]) + Integer.parseInt(stringTokenizer.nextToken());

            for(int i=2; i<num; i++){
                stringTokenizer = new StringTokenizer(br.readLine());

                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(stringTokenizer.nextToken());
                dp[i][1] = Math.min(Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]), dp[i][0]) + Integer.parseInt(stringTokenizer.nextToken());
                dp[i][2] = Math.min(Math.min(dp[i-1][1], dp[i-1][2]), dp[i][1]) + Integer.parseInt(stringTokenizer.nextToken());
            }

            bw.write(caseNum++ + ". " + dp[num-1][1] + "\n");
        }

        bw.flush();
    }
}
