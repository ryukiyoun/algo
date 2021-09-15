package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*간단 문제 풀이*/
        if((Integer.parseInt(br.readLine()) & 1) == 1)
            bw.write("SK\n");
        else
            bw.write("CY\n");

        bw.flush();

        /*DP를 이용하여 문제 풀이*/
        int rockCnt = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[rockCnt+1];

        if(rockCnt>1)
            dp[2] = true;

        for(int i=4; i<=rockCnt; i++){
            dp[i] = !dp[i-1];
        }

        if(dp[rockCnt])
            bw.write("CY\n");
        else
            bw.write("SK\n");
        bw.flush();
    }
}
