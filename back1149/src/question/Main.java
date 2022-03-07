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

        int houseCnt = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        int[][] dp = new int[3][houseCnt];

        dp[0][0] = Integer.parseInt(stringTokenizer.nextToken());
        dp[1][0] = Integer.parseInt(stringTokenizer.nextToken());
        dp[2][0] = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=1; i<houseCnt; i++){
            stringTokenizer = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++) {
                int price = Integer.parseInt(stringTokenizer.nextToken());

                if(j == 0)
                    dp[j][i] = Math.min(dp[1][i-1] + price, dp[2][i-1] + price);
                else if(j == 1)
                    dp[j][i] = Math.min(dp[0][i-1] + price, dp[2][i-1] + price);
                else
                    dp[j][i] = Math.min(dp[0][i-1] + price, dp[1][i-1] + price);
            }
        }

        int result = Math.min(dp[0][houseCnt-1], dp[1][houseCnt-1]);
        result = Math.min(result, dp[2][houseCnt-1]);

        bw.write(result + "\n");
        bw.flush();
    }
}
