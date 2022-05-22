package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (queue.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(queue.poll() + "\n");
            } else
                queue.add(number);
        }

        bw.flush();
    }
}
