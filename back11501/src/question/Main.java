package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer strToken;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int days = Integer.parseInt(br.readLine());
            strToken = new StringTokenizer(br.readLine());

            int[][] dp = new int[days][days];

            for(int d=0; d<days; d++){
                for(int d2=0; d2<days; d2++){
                    if(d==d2 || d2>d)
                        dp[d][d2] = 0;
                }
            }
        }
    }
}