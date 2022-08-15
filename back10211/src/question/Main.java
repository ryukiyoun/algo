package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            int arrayNum = Integer.parseInt(br.readLine());
            int[][] dp = new int[arrayNum][arrayNum];

            stringTokenizer = new StringTokenizer(br.readLine());

            dp[0][0] = Integer.parseInt(stringTokenizer.nextToken());
            int result = dp[0][0];

            for(int col=1; col<arrayNum; col++) {
                dp[0][col] = Integer.parseInt(stringTokenizer.nextToken());

                if(result < dp[0][col])
                    result = dp[0][col];
            }

            for(int row=1; row<arrayNum; row++){
                for(int col=0; col<arrayNum-row; col++){
                    dp[row][col] = dp[row-1][col] + dp[0][row+col];

                    if(result < dp[row][col])
                        result = dp[row][col];
                }
            }

            bw.write(result + "\n");
            bw.flush();
        }
    }
}
