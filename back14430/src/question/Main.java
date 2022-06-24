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

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int column = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[row+1][column+1];

        for(int i=1; i<=row; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=1; j<=column; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        bw.write(dp[row][column] + "\n");
        bw.flush();
    }
}
