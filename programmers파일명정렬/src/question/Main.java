package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        solution.solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }

    public static class Solution {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            PriorityQueue<SortFile> queue = new PriorityQueue<>();
            for(int i=0; i<files.length; i++)
                queue.add(new SortFile(files[i], i));

            for(int i=0; i<files.length; i++)
                answer[i] = queue.poll().toString();

            return answer;
        }

        public static class SortFile implements Comparable<SortFile>{
            private String head, number, tail;
            private int index;

            public SortFile(String fileName, int index){
                StringBuilder headBuilder = new StringBuilder();
                StringBuilder numberBuilder = new StringBuilder();
                StringBuilder tailBuilder = new StringBuilder();

                boolean isHead = true;
                boolean isNumber = true;
                for(char sub : fileName.toCharArray()){
                    if(48 <= sub && sub <= 57 && isNumber){
                        isHead = false;
                        numberBuilder.append(sub);
                    }
                    else if(isHead)
                        headBuilder.append(sub);
                    else {
                        isNumber = false;
                        tailBuilder.append(sub);
                    }
                }

                head = headBuilder.toString();
                number = numberBuilder.toString();
                tail = tailBuilder.toString();
                this.index = index;
            }

            @Override
            public int compareTo(SortFile o) {
                if(this.head.compareToIgnoreCase(o.head) == 0){
                    if(Integer.parseInt(this.number) == Integer.parseInt(o.number)){
                        return Integer.compare(this.index, o.index);
                    }
                    return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
                }
                else
                    return this.head.compareToIgnoreCase(o.head);
            }

            @Override
            public String toString() {
                return head + number + tail;
            }
        }
    }
}
