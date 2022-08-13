package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int height = Integer.parseInt(br.readLine());

        int[][] dp = new int[height][height];

        dp[0][0] = Integer.parseInt(br.readLine());

        for(int i=1; i<height; i++){
            stringTokenizer = new StringTokenizer(br.readLine());

            dp[i][0] = dp[i-1][0] + Integer.parseInt(stringTokenizer.nextToken());

            for(int j=1; j<=i; j++){
                int num = Integer.parseInt(stringTokenizer.nextToken());
                dp[i][j] = num + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        Arrays.sort(dp[height-1]);

        bw.write(dp[height-1][height-1] + "\n");
        bw.flush();
    }
}
