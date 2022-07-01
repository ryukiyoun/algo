package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//todo 문제해결 못함
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(stringTokenizer.nextToken());
        int chapterCnt = Integer.parseInt(stringTokenizer.nextToken());

        int[] dp = new int[day+1];

        for(int i=0; i<chapterCnt; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int chapterDay = Integer.parseInt(stringTokenizer.nextToken());
            int chapterPage = Integer.parseInt(stringTokenizer.nextToken());

            for(int j=day-chapterDay; j>0; j--){
                if(dp[j] != 0)
                    dp[j+chapterDay] = dp[j] + chapterPage;
            }

            dp[chapterDay] = Math.max(dp[chapterDay], chapterPage);
        }

        Arrays.sort(dp);

        bw.write(dp[day] + "\n");
        bw.flush();
    }
}
