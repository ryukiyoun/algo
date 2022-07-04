package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        int[] arr  = new int[num];
        BigInteger[] dp = new BigInteger[num];
        Arrays.fill(dp, BigInteger.ZERO);

        dp[0] = BigInteger.ONE;

        for(int i=0; i<num; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=1; i<num; i++){
            BigInteger sum = BigInteger.ZERO;

            for(int j=0; j<i; j++){
                if(BigInteger.valueOf(arr[j]).compareTo(BigInteger.valueOf(arr[i])) < 0)
                    sum = sum.add(dp[j]);
            }
            dp[i] = sum.add(BigInteger.ONE).mod(BigInteger.valueOf(998244353));
        }

        for(int i=0; i<num; i++) {
            if(i == 0)
                bw.write(dp[i].toString());
            else
                bw.write(" " + dp[i]);
        }

        bw.write("\n");
        bw.flush();
    }
}
