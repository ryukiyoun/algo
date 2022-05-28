package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        long[] dp = new long[num+1];
        dp[0] = 1;

        for(int i=0; i<=Math.ceil(Math.log10(num)/Math.log10(2)); i++){
            for(int j=1; j<=num; j++){
                if(Math.pow(2,i) <= j){
                    dp[j] = (dp[j] + dp[j-(int)Math.pow(2,i)]) % 1000000000;
                }
            }
        }

        bw.write(dp[num] + "\n");
        bw.flush();
    }
}
