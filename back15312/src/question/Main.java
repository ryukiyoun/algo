package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String nameA = br.readLine();
        String nameB = br.readLine();

        int nameLength = nameA.length() * 2;

        int[][] dp = new int[nameLength][nameLength];

        for(int i=0; i<nameLength; i+=2){
            dp[0][i] = alpha[nameA.charAt(i/2) - 65];
            dp[0][i+1] = alpha[nameB.charAt(i/2) - 65];
        }

        for(int i=1; i<nameLength; i++){
            for(int j=0; j<nameLength - i; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % 10;
            }
        }

        bw.write(dp[nameLength-2][0] + "" + dp[nameLength-2][1] + "\n");
        bw.flush();
    }
}
