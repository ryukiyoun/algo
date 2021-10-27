package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] matrix;
    private static boolean[] check;
    private static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nCnt = Integer.parseInt(br.readLine());
        matrix = new int[nCnt+1][nCnt+1];
        check = new boolean[nCnt+1];

        int eCnt = Integer.parseInt(br.readLine());

        for(int i=0; i<eCnt; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stringTokenizer.nextToken());
            int column = Integer.parseInt(stringTokenizer.nextToken());
            matrix[row][column] = 1;
            matrix[column][row] = 1;
        }

        System.out.println(DFS(1));
    }

    public static int BFS(int startNode){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        check[startNode] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=1; i< matrix.length; i++){
                if(matrix[node][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static int DFS(int startNode){
        check[startNode] = true;

        for(int i=1; i< matrix.length; i++){
            if(matrix[startNode][i] == 1 && !check[i]) {
                count++;
                DFS(i);
            }
        }

        return count;
    }
}
