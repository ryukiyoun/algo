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

        int dayCnt = Integer.parseInt(br.readLine());

        int[] time = new int[dayCnt+1];
        int[] price = new int[dayCnt+1];

        int[] dp = new int[dayCnt+1];

        for(int i=0; i<dayCnt; i++){
            stringTokenizer = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(stringTokenizer.nextToken());
            price[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if(dayCnt < time[dayCnt-1] + dayCnt-1)
            dp[dayCnt-1] = 0;
        else
            dp[dayCnt-1] = price[dayCnt-1];

        for(int i=dayCnt-2; i>-1; i--){
            if(time[i] == 1)
                dp[i] = dp[i+1] + price[i];
            else if(dayCnt < time[i] + i)
                dp[i] = dp[i+1];
            else
                dp[i] = Math.max(dp[i+time[i]] + price[i], dp[i+1]);
        }

        bw.write(dp[0] + "\n");
        bw.flush();
    }
}
