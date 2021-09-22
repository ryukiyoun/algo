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
        stringTokenizer = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];

        dp[0] = 1;

        for(int i=0; i<num; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=1; i<num; i++){
            int boxCntMax = 0;
            for(int j=0; j<i; j++) {
                if (arr[i] > arr[j])
                    boxCntMax = Math.max(boxCntMax, dp[j]);
            }
            dp[i] = boxCntMax + 1;
        }

        Arrays.sort(dp);

        bw.write(dp[num-1] + "\n");
        bw.flush();
    }
}
