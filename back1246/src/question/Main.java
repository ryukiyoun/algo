package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(br.readLine());

        int eggCnt = Integer.parseInt(stringTokenizer.nextToken());
        int peopleCnt = Integer.parseInt(stringTokenizer.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<peopleCnt; i++)
            queue.add(Integer.parseInt(br.readLine()));

        int max = 0, multiple = 1;
        while(!queue.isEmpty()) {
            max = Math.max(max, queue.poll() * multiple);

            if(multiple < eggCnt)
                multiple++;
            else
                break;
        }

        System.out.println(max);
    }
}
