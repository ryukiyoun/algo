package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int appleCnt = Integer.parseInt(br.readLine());

        int result = 0, now = 1, offset = M - 1;
        for (int i = 0; i < appleCnt; i++) {
            int apple = Integer.parseInt(br.readLine());

            if(!(now <= apple && apple <= now + offset)){
                if(apple >= now){
                    result += apple - now - offset;
                    now += apple - now - offset;
                }
                else{
                    result += now - apple;
                    now += apple - now;
                }
            }
        }

        System.out.println(result);
    }
}
