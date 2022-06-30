package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(stringTokenizer.nextToken());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());

        int offset = 0;
        for(int i=0; i<num; i++){
            if(a + d * offset == Integer.parseInt(stringTokenizer.nextToken()))
                offset++;
        }

        System.out.println(offset);
    }
}
