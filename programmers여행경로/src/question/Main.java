package question;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[][] {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}}));
        System.out.println(solution.solution(new String[][] {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}}));
        System.out.println(solution.solution(new String[][] {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}}));
        System.out.println(solution.solution(new String[][] {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}}));
        System.out.println(solution.solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}));
    }

    public static class Solution {
        private List<String> list;
        public String[] solution(String[][] tickets) {
            list = new ArrayList<>();

            for(int i=0; i< tickets.length; i++) {
                boolean[] check = new boolean[tickets.length];
                if(tickets[i][0].equals("ICN")) {
                    check[i] = true;
                    BFS(tickets[i][1], check, tickets, tickets[i][0]);
                }
            }

            Collections.sort(list);

            return list.get(0).split(",");
        }

        public void BFS(String dest, boolean[] check, String[][] tickets, String result){
            for(int i=0; i< tickets.length; i++){
                if(!check[i] && tickets[i][0].equals(dest)){
                    check[i] = true;
                    BFS(tickets[i][1], check, tickets, result + "," + dest);
                    check[i] = false;
                }
            }

            if(result.split(",").length == tickets.length)
                list.add(result + "," + dest);
        }
    }
}
