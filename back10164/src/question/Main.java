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
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int cRow = k / column + (k % column > 0 ? 1 : 0);
        int cColumn = k - (cRow - 1) * column;

        int[][] dp = new int[row + 1][column + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 && j == 1)
                    continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if(k != 0)
            bw.write(dp[cRow][cColumn] * dp[row - cRow + 1][column - cColumn + 1] + "\n");
        else
            bw.write(dp[row][column] + "\n");
        bw.flush();
    }
}
