package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int bookCnt = Integer.parseInt(br.readLine());

        List<Integer> bookList = new ArrayList<>();

        for(int i=0; i<bookCnt; i++)
            bookList.add(Integer.parseInt(br.readLine()));

        int result = 0;

        Collections.reverse(bookList);

        int target = bookCnt;

        for(int i=0; i<bookCnt; i++){
            if(bookList.get(i) == target)
                target--;
            else
                result++;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
