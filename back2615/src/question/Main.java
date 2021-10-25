package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] direction = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        int[][] concave = new int[21][21];

        for (int i = 1; i <= 19; i++)
            concave[i] = Arrays.stream(("0 " + br.readLine() + " 0").split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                int rock = concave[i][j];
                if (rock == 0)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int rockX = i, rockY = j, count = 1;

                    if(concave[rockX - direction[k][0]][rockY - direction[k][1]] == rock)
                        continue;

                    while(true){
                        rockX += direction[k][0];
                        rockY += direction[k][1];

                        if(rockX < 1 || rockY < 1 || rockX > 19 || rockY > 19 || concave[rockX][rockY] != rock)
                            break;
                        else
                            count++;
                    }

                    if(count == 5) {
                        bw.write(rock + "\n");
                        bw.write(String.format("%d %d\n", i, j));
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write("0\n");
        bw.flush();
    }
}
