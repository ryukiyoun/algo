package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        int result = 0;
        long counter = 1;

        while(true){
            if(num - counter >= 0){
                num -= counter;
                result++;
                counter++;
            }
            else
                break;
        }

        System.out.println(result);
    }
}
