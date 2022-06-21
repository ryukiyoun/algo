package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Switcher switcher = new Switcher(br.readLine());

        System.out.println(switcher.offBulb());
    }

    public static class Switcher{
        private String bulbString;
        private boolean[] bulbStatus;

        public Switcher(String bulbString){
            this.bulbString = bulbString;

            bulbStatus = new boolean[bulbString.length() + 1];

            for(int i=0; i<bulbString.length(); i++)
                bulbStatus[i+1] = bulbString.charAt(i) == 'Y';
        }

        public int offBulb(){
            int result = 0;

            for(int i=1; i<=bulbString.length(); i++){
                if(bulbStatus[i]) {
                    result++;
                    for (int j = 1; j <= bulbString.length() / i; j++) {
                        bulbStatus[i*j] = !bulbStatus[i*j];
                    }
                }
            }

            return result;
        }
    }
}
