package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

//todo 문제해결 못함
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] moveY = {2, 1, -1, -2, -2, -1, 1, 2};

        stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int startX = Integer.parseInt(stringTokenizer.nextToken());
        int startY = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, Point[]> dp = new HashMap<>();

        Point[] startPoint = {new Point(startX, startY)};
        dp.put(0, startPoint);

        if(K == 0)
            bw.write("1\n");
        else{
            for(int i=0; i<K; i++){
                Point[] pointList = dp.get(i);
                List<Point> nextPointList = new ArrayList<>();
                for(int j=0; j<pointList.length; j++){
                    Point point = pointList[j];
                    for(int m=0; m<8; m++) {
                        if(point.x + moveX[m] > 0 && point.y + moveY[m] > 0 && point.x + moveX[m] <= N && point.y + moveY[m] <= N)
                            nextPointList.add(new Point(point.x + moveX[m], point.y + moveY[m]));
                    }
                }
                dp.remove(i);
                dp.put(i+1, nextPointList.toArray(new Point[0]));
            }

            BigDecimal result = BigDecimal.valueOf(dp.get(K).length).divide(BigDecimal.valueOf(8).pow(K));
            bw.write(result + "\n");
        }

        bw.flush();
    }

    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
