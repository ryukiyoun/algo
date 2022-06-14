package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num];
        Arrays.fill(dp, 99999);
        dp[0] = 0;

        stringTokenizer = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++){
            int jumpAble = Integer.parseInt(stringTokenizer.nextToken());

            for(int j=1; j<=jumpAble; j++){
                if(i+j < num)
                    dp[i+j] = Math.min(dp[i] + 1, dp[i+j]);
            }
        }

        if(1000 < dp[num-1])
            bw.write("-1\n");
        else
            bw.write(dp[num-1] + "\n");
        bw.flush();
    }
}
