package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        long[] arr = new long[num];

        for (int i = 0; i < num; i++)
            arr[i] = Long.parseLong(br.readLine());

        Arrays.sort(arr);

        long result = -1;
        for (int i = arr.length - 1; i > 1; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                result = arr[i] + arr[i - 1] + arr[i - 2];
                break;
            }
        }

        System.out.println(result);
    }
}
