package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution("ABC", new String[]{"13:00,13:05,WORLD2,ABCDEF", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public static class Solution {
        public String solution(String m, String[] musicinfos) {
            m = changeStr(m);

            PriorityQueue<Music> priorityQueue = new PriorityQueue<>();

            for (int i = 0; i < musicinfos.length; i++) {
                String[] info = musicinfos[i].split(",");

                String musicM = changeStr(info[3]);

                int startTime = Integer.parseInt(info[0].split(":")[0]) * 60 + Integer.parseInt(info[0].split(":")[1]);
                int endTime = Integer.parseInt(info[1].split(":")[0]) * 60 + Integer.parseInt(info[1].split(":")[1]);

                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < endTime - startTime; j++)
                    stringBuilder.append(musicM.charAt(j % musicM.length()));

                if (stringBuilder.toString().contains(m))
                    priorityQueue.offer(new Music(endTime - startTime, info[2], i));
            }

            if (priorityQueue.isEmpty())
                return "(None)";
            else
                return priorityQueue.poll().name;
        }

        public String changeStr(String str) {
            str = str.replace("A#", "H");
            str = str.replace("G#", "I");
            str = str.replace("F#", "J");
            str = str.replace("D#", "K");
            str = str.replace("C#", "L");

            return str;
        }

        public class Music implements Comparable<Music> {
            private long time;
            private String name;
            private int index;

            public Music(long time, String name, int index) {
                this.time = time;
                this.name = name;
                this.index = index;
            }

            @Override
            public int compareTo(Music o) {
                if (this.time == o.time) {
                    return Integer.compare(this.index, o.index);
                }

                return Long.compare(o.time, this.time);
            }
        }
    }
}
