package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);

        int dpElement = 1;
        int index = 2;

        while (num > dpElement) {
            if ((index & 1) == 0)
                dpElement = dp.get(index - 1) + (index + 1) * (index / 2);
            else
                dpElement = dp.get(index - 1) + ((index / 2) + 1) * index;

            dp.add(dpElement);
            index++;
        }

        int[] dpCnt = new int[num + 1];
        Arrays.fill(dpCnt, 1234567);
        dpCnt[0] = 0;
        dpCnt[1] = 1;

        for(int i=2; i<=num; i++){
            for(int j=1; j<dp.size(); j++){
                if(dp.get(j) < i)
                    dpCnt[i] = Math.min(dpCnt[i], dpCnt[i - dp.get(j)] + 1);
                else if(dp.get(j) == i)
                    dpCnt[i] = 1;
            }
        }

        bw.write(dpCnt[num] + "\n");
        bw.flush();
    }
}
