package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution.solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution.solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));

    }

    public static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            int loop = n;
            int seat = m;

            Queue<String> queue = Arrays.stream(timetable).sorted((o1, o2) -> {
                String[] o1S = o1.split(":");
                String[] o2S = o2.split(":");

                if (Integer.parseInt(o1S[0]) == Integer.parseInt(o2S[0]))
                    return Integer.compare(Integer.parseInt(o1S[1]), Integer.parseInt(o2S[1]));
                else
                    return Integer.compare(Integer.parseInt(o1S[0]), Integer.parseInt(o2S[0]));
            }).collect(Collectors.toCollection(LinkedList::new));

            String time = "09:00";
            while (loop != 1) {
                while (seat != 0 &&!queue.isEmpty()) {
                    String person = queue.peek();
                    if (compareTime(person, time)) {
                        queue.poll();
                        seat--;
                    }
                    else
                        break;
                }

                seat = m;
                time = addTime(time, t);
                loop--;
            }

            while (seat != 1 && !queue.isEmpty()) {
                String person = queue.peek();
                if (compareTime(person, time)) {
                    queue.poll();
                    seat--;
                }
                else
                    break;
            }

            if(queue.isEmpty())
                return time;
            else{
                String lastPerson = queue.peek();

                if(compareTime(lastPerson, time))
                    return addTime(lastPerson, -1);
                else
                    return time;
            }
        }

        public String addTime(String time, int appendMin) {
            String[] splitTime = time.split(":");

            int timeHour = Integer.parseInt(splitTime[0]);
            int timeMin = Integer.parseInt(splitTime[1]);

            LocalTime localTime = LocalTime.of(timeHour, timeMin);
            localTime = localTime.plusMinutes(appendMin);

            return localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        }

        public boolean compareTime(String person, String time) {
            String[] splitPerson = person.split(":");
            String[] splitTime = time.split(":");

            int personHour = Integer.parseInt(splitPerson[0]);
            int personMin = Integer.parseInt(splitPerson[1]);

            int timeHour = Integer.parseInt(splitTime[0]);
            int timeMin = Integer.parseInt(splitTime[1]);

            LocalTime localTime = LocalTime.of(timeHour, timeMin);
            LocalTime personTime = LocalTime.of(personHour, personMin);

            return localTime.compareTo(personTime) != -1;
        }
    }
}
