package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        Checker checker = new Checker();
        int funCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<funCnt; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            String function = stringTokenizer.nextToken();

            if(!function.equals("all") && !function.equals("empty")) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                checker.processing(function, num);
            }
            else
                checker.processing(function);
        }

        bw.flush();
    }

    public static class Checker{
        private final boolean[] data = new boolean[21];

        public void processing(String function, int num) throws Exception{
            switch (function){
                case "add" :
                    add(num);
                    break;

                case "remove" :
                    remove(num);
                    break;

                case "check" :
                    bw.write(check(num) + "\n");
                    break;

                case "toggle" :
                    toggle(num);
                    break;
            }
        }

        public void processing(String function){
            switch (function){
                case "all" :
                    all();
                    break;

                case "empty" :
                    empty();
                    break;
            }
        }

        private void add(int num){
            data[num] = true;
        }

        private void remove(int num){
            data[num] = false;
        }

        private String check(int num){
            return data[num] ? "1" : "0";
        }

        private void toggle(int num){
            data[num] = !data[num];
        }

        private void all(){
            Arrays.fill(data, true);
        }

        private void empty(){
            Arrays.fill(data, false);
        }
    }
}
