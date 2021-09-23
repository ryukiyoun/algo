package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int resultCnt = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < resultCnt; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(stringTokenizer.nextToken());
            int col1 = Integer.parseInt(stringTokenizer.nextToken());

            int row2 = Integer.parseInt(stringTokenizer.nextToken());
            int col2 = Integer.parseInt(stringTokenizer.nextToken());

            int result = dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];

            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
