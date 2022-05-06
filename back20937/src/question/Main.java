package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[500001];

        stringTokenizer = new StringTokenizer(br.readLine());

        int max = 0;
        for(int i=0; i<num; i++) {
            int bowl = Integer.parseInt(stringTokenizer.nextToken());
            arr[bowl]++;

            max = Math.max(max, arr[bowl]);
        }

        System.out.println(max);
    }
}
