package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int commandCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<commandCnt; i++)
            stack.run(br.readLine());
    }

    public static class Stack{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> stackValue = new ArrayList<>();

        public void run(String command) throws Exception{
            StringTokenizer strToken = new StringTokenizer(command);

            switch (strToken.nextToken()){
                case "push" :
                    stackValue.add(Integer.parseInt(strToken.nextToken()));
                    break;
                case "pop" :
                    if(stackValue.size() == 0)
                        bw.write(-1 + "\n");
                    else{
                        bw.write(stackValue.get(stackValue.size() - 1) + "\n");
                        stackValue.remove(stackValue.size() - 1);
                    }
                    break;
                case "size" :
                    bw.write(stackValue.size() + "\n");
                    break;
                case "empty" :
                    if(stackValue.size() == 0)
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "top" :
                    if(stackValue.size() == 0)
                        bw.write(-1 + "\n");
                    else
                        bw.write(stackValue.get(stackValue.size() - 1) + "\n");
                    break;
            }
            bw.flush();
        }
    }
}
