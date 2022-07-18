package question;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"classic", "pop"}, new int[]{500, 100}));
    }

    public static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            if (genres.length == 1)
                return new int[]{0};

            Map<String, Genre> map = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if (map.containsKey(genres[i])) {
                    Genre genre = map.get(genres[i]);
                    genre.count += plays[i];
                    genre.musics.offer(new Music(i, plays[i]));
                } else
                    map.put(genres[i], new Genre(i, plays[i]));
            }

            List<Genre> valueList = new ArrayList<>(map.values());
            valueList.sort((o1, o2) -> Integer.compare(o2.count, o1.count));

            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < valueList.size(); i++) {
                answer.add(valueList.get(i).musics.poll().index);
                if(!valueList.get(i).musics.isEmpty())
                    answer.add(valueList.get(i).musics.poll().index);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        public class Genre {
            private PriorityQueue<Music> musics;
            private int count;

            public Genre(int index, int count) {
                musics = new PriorityQueue<>();
                this.count = count;
                musics.offer(new Music(index, count));
            }
        }

        public class Music implements Comparable<Music> {
            private int index;
            private int count;

            public Music(int index, int count) {
                this.index = index;
                this.count = count;
            }

            @Override
            public int compareTo(Music o) {
                if (this.count == o.count) {
                    return Integer.compare(this.index, o.index);
                } else {
                    return Integer.compare(o.count, this.count);
                }
            }
        }
    }
}
