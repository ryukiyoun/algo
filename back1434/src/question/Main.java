package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int boxNum = Integer.parseInt(stringTokenizer.nextToken());
        int bookNum = Integer.parseInt(stringTokenizer.nextToken());

        int[] boxArr = new int[boxNum];
        int[] bookArr = new int[bookNum + 1];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < boxNum; i++)
            boxArr[i] = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < bookNum; i++)
            bookArr[i] = Integer.parseInt(stringTokenizer.nextToken());

        int boxIndex = 0, bookIndex = 0, result = 0;

        while (bookIndex < bookNum) {
            int remainder = boxArr[boxIndex] - bookArr[bookIndex];
            if (remainder >= 0) {
                boxArr[boxIndex] = remainder;
                bookIndex++;
            } else
                boxIndex++;
        }

        for (int i = 0; i < boxNum; i++)
            result += boxArr[i];

        bw.write(result + "\n");
        bw.flush();
    }
}
