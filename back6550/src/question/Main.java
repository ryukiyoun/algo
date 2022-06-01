package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        String input;
        while((input = br.readLine()) != null) {
            stringTokenizer = new StringTokenizer(input);

            String s = stringTokenizer.nextToken();
            String t = stringTokenizer.nextToken();

            if(s.length() - t.length() > 0)
                System.out.println("No");
            else {
                int preStrIndex = 0;
                for (char subStr : s.toCharArray()) {
                    preStrIndex = t.indexOf(subStr, preStrIndex);

                    if (preStrIndex == -1) {
                        System.out.println("No");
                        break;
                    }
                    preStrIndex++;
                }

                if (preStrIndex != -1)
                    System.out.println("Yes");
            }
        }
    }
}
