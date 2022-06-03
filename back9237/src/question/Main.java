package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        stringTokenizer = new StringTokenizer(br.readLine());

        int[] treeArr = new int[num];

        for(int i=0; i<num; i++)
            treeArr[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(treeArr);

        int day = 2, result = 0;
        for(int i=num-1; i>-1; i--)
            result = Math.max(result, treeArr[i] + day++);

        System.out.println(result);
    }
}
