package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if((Integer.parseInt(br.readLine()) & 1) == 0)
            bw.write("SK\n");
        else
            bw.write("CY\n");

        bw.flush();
    }
}

