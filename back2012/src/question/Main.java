package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num + 1];

        for (int i = 1; i <= num; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long result = 0;
        for (int i = 1; i <= num; i++)
            result += Math.abs(arr[i] - i);

        System.out.println(result);
    }
}