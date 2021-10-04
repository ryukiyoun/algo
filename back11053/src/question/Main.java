package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int length = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        int[] arr = new int[length];
        int[] dp = new int[length];

        for(int i=0; i<length; i++) {
            dp[i] = 1;
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        Arrays.sort(dp);

        bw.write(dp[length-1] + "\n");
        bw.flush();
    }
}
