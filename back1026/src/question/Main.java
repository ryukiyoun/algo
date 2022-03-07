package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] AArray = new int[num];
        int[] BArray = new int[num];

        StringTokenizer AStringTokenizer = new StringTokenizer(br.readLine());
        StringTokenizer BStringTokenizer = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++){
            AArray[i] = Integer.parseInt(AStringTokenizer.nextToken());
            BArray[i] = Integer.parseInt(BStringTokenizer.nextToken());
        }

        Arrays.sort(AArray);
        Arrays.sort(BArray);

        int result = 0;
        for(int i=0; i<num; i++)
            result += AArray[i] * BArray[num - i -1];

        System.out.println(result);
    }
}
