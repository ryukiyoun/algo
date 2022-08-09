package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
//재풀이
//todo 시간초과
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        List<String> listenList = new ArrayList<>();
        List<String> lookList = new ArrayList<>();

        stringTokenizer = new StringTokenizer(br.readLine());

        int listenCnt = Integer.parseInt(stringTokenizer.nextToken());
        int lookCnt = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < listenCnt; i++)
            listenList.add(br.readLine());

        for (int i = 0; i < lookCnt; i++)
            lookList.add(br.readLine());

        Collections.sort(listenList);
        Collections.sort(lookList);

        int resultCnt = 0;
        List<String> result = new ArrayList<>();

        if (listenCnt > lookCnt) {
            for (int i = 0; i < lookCnt; i++) {
                if (listenList.contains(lookList.get(i))) {
                    resultCnt++;
                    result.add(lookList.get(i));
                }
            }
        } else {
            for (int i = 0; i < listenCnt; i++) {
                if (lookList.contains(listenList.get(i))) {
                    resultCnt++;
                    result.add(listenList.get(i));
                }
            }
        }

        Collections.sort(result);

        bw.write(resultCnt + "\n");
        for (int i = 0; i < result.size(); i++)
            bw.write(result.get(i) + "\n");

        bw.flush();
    }
}
