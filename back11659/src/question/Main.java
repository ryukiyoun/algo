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

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());

        int[] dp = new int[num + 1];

        stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 1; i <= num; i++)
            dp[i] = dp[i - 1] + Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            bw.write((dp[end] - dp[start - 1]) + "\n");
            bw.flush();
        }
    }
}
