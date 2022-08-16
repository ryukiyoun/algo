package question;

import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.math.BigInteger;
        import java.util.Arrays;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        BigInteger[][] dp = new BigInteger[11][num];

        for(int i=0; i<11; i++)
            Arrays.fill(dp[i], BigInteger.valueOf(0));

        BigInteger result = BigInteger.valueOf(0);

        for(int i=1; i<11; i++){
            for(int j=0; j<num; j++){
                if(j==0)
                    dp[i][j] = BigInteger.valueOf(1);
                else
                    dp[i][j] = (dp[i-1][j].add(dp[i][j-1]));

                if(j == num-1)
                    result = result.add(dp[i][j]);
            }
        }

        bw.write(result.mod(BigInteger.valueOf(10007)) + "\n");
        bw.flush();
    }
}
