package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while((input = br.readLine()) != null) {
            String[] numbers = input.split(" ");

            int first = Integer.parseInt(numbers[0]);
            int middle = Integer.parseInt(numbers[1]);
            int last = Integer.parseInt(numbers[2]);
            int result = 0;

            while(true) {
                int lg = middle - first;
                int rg = last - middle;

                if(lg == 1 && rg == 1)
                    break;

                if (lg < rg) {
                    first = middle;
                    middle = middle+1;
                }
                else {
                    last = middle;
                    middle = middle-1;
                }

                result++;
            }

            bw.write(result + "\n");
            bw.flush();
        }
    }
}
