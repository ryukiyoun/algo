package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String funStr = br.readLine();
            int arrCnt = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            AC ac = new AC(funStr, arrCnt, arrStr);
            ac.calc();
            ac.resultPrint();
        }
    }

    public static class AC {
        String funStr;

        int arrCnt, start, end;

        int[] numbers;

        boolean isError = false;
        boolean isRevert = false;

        public AC(String funStr, int arrCnt, String arrStr) {
            this.funStr = funStr.replaceAll("RR", "");
            this.arrCnt = arrCnt;
            this.end = arrCnt - 1;
            this.numbers = new int[arrCnt];

            makeNumberArray(arrCnt, arrStr);
        }

        public void makeNumberArray(int arrCnt, String arrStr) {
            StringTokenizer stringTokenizer = new StringTokenizer(arrStr, "[],");

            for (int i = 0; i < arrCnt; i++)
                this.numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        public void calc() {
            for (char fun : funStr.toCharArray()) {
                if (fun == 'R') {
                    int temp = start;
                    start = end;
                    end = temp;

                    isRevert = !isRevert;
                } else {
                    if (arrCnt == 0) {
                        isError = true;
                        break;
                    }
                    else {
                        if (isRevert)
                            start--;
                        else
                            start++;

                        arrCnt--;
                    }
                }
            }
        }

        public void resultPrint() throws Exception{
            if(isError)
                bw.write("error\n");
            else {
                StringBuilder stringBuilder = new StringBuilder("[");

                if (isRevert) {
                    for (int i = start; i >= end; i--) {
                        if (i != start)
                            stringBuilder.append(",");

                        stringBuilder.append(numbers[i]);
                    }
                } else {
                    for (int i = start; i <= end; i++) {
                        if (i != start)
                            stringBuilder.append(",");

                        stringBuilder.append(numbers[i]);
                    }
                }

                stringBuilder.append("]");

                bw.write(stringBuilder.toString() + "\n");
            }

            bw.flush();
        }
    }
}
