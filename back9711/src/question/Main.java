package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//todo 문제해결 못함
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++){
            stringTokenizer = new StringTokenizer(br.readLine());

            int fiboNum = Integer.parseInt(stringTokenizer.nextToken());
            int divide = Integer.parseInt(stringTokenizer.nextToken());

            if(divide == 1)
                bw.write("Case #" + i + ": " + 0 + "\n");
            else {
                int[] dp = new int[fiboNum+1];
                dp[1] = 1;
                if (fiboNum > 1)
                    dp[2] = 1;

                for (int j = 3; j <= fiboNum; j++)
                    dp[j] = (dp[j - 1] + dp[j - 2]) % divide;

                bw.write("Case #" + i + ": " + dp[fiboNum] + "\n");
            }

            bw.flush();
        }
    }
}
