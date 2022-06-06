package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// todo 해설 참조함 다시 풀어볼 필요 있음
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rockCnt = Integer.parseInt(br.readLine());

        int[] dp = new int[rockCnt+1];

        if(rockCnt>1)
            dp[2] = 1;

        for(int i=7; i<=rockCnt; i++){
            if(dp[i-4] + dp[i-3] + dp[i-1] == 0)
                dp[i] = 1;
        }

        if(dp[rockCnt] == 1)
            bw.write("CY\n");
        else
            bw.write("SK\n");

        bw.flush();
    }
}
