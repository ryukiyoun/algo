package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        stringTokenizer = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(arr);

        System.out.println(arr[(num-1)/2]);

        Set<Integer> result = new HashSet<>();

        result.add(1);
        result.add(11);
        result.add(2);

        Arrays.sort(result.stream().mapToInt(Integer::intValue).toArray());
    }
}
