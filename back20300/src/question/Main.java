package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(br.readLine());
        List<Long> arr = new ArrayList<>();

        stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++)
            arr.add(Long.parseLong(stringTokenizer.nextToken()));

        Collections.sort(arr);

        if ((num & 1) == 1)
            arr.remove(arr.size() - 1);

        long max = 0;
        for (int i = 0; i < arr.size() / 2; i++)
            max = Math.max(max, arr.get(i) + arr.get(arr.size() - i -1));

        System.out.println(max);
    }
}
