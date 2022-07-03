package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int sun = Integer.parseInt(stringTokenizer.nextToken());
        int water = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(sun + water + (Math.min(sun, water) / 10));
    }
}
