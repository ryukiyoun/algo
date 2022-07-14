package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static class Solution {
        public int[] solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();
            int[] impress1 = {1, 2, 3, 4, 5};
            int[] impress2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] impress3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            Person[] correct = new Person[3];

            for (int i = 0; i < 3; i++)
                correct[i] = new Person(i + 1);

            for (int i = 0; i < answers.length; i++) {
                if (impress1[i % 5] == answers[i])
                    correct[0].correct++;

                if (impress2[i % 8] == answers[i])
                    correct[1].correct++;

                if (impress3[i % 10] == answers[i])
                    correct[2].correct++;
            }

            Arrays.sort(correct);
            answer.add(correct[correct.length - 1].index);

            for (int i = 1; i > -1; i--) {
                if (correct[i + 1].correct == correct[i].correct)
                    answer.add(correct[i].index);
                else
                    break;
            }

            return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
        }

        public static class Person implements Comparable<Person> {
            int correct;
            int index;

            public Person(int index) {
                this.index = index;
            }

            @Override
            public int compareTo(Person o) {
                return Integer.compare(this.correct, o.correct);
            }
        }
    }
}
