package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        String[][] temp = {
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
                {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                {"Jeju", "Pangyo", "NewYork", "newyork"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
        };
        int[] temp2 = {3, 3, 2, 5, 2, 0};

        for (int i = 0; i < 6; i++)
            System.out.println(solution.solution(temp2[i], temp[i]));
    }

    public static class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0)
                return 5 * cities.length;

            int runningTime = 0;
            List<String> cache = new LinkedList<>();

            for (String city : cities) {
                city = city.toLowerCase();
                if (cache.contains(city)) {
                    runningTime++;
                    cache.remove(city);
                } else {
                    runningTime += 5;
                    if (cache.size() == cacheSize)
                        cache.remove(0);
                }
                cache.add(city);
            }

            return runningTime;
        }
    }

    /*public static class Cache {
        private Map<String, Node> map;
        private int runningTime = 0;
        private int capacity = 0;
        private Node firstNode = new Node("first");
        private Node lastNode = new Node("last");

        public Cache(int size) {
            map = new HashMap<>();
            this.capacity = size;
            firstNode.next = lastNode;
            lastNode.pre = firstNode;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(node.key);
        }

        private void insert(Node node) {
            this.firstNode.next.pre = node;
            node.next = this.firstNode.next;
            node.pre = this.firstNode;
            this.firstNode.next = node;

            map.put(node.key, node);
        }

        public void put(String key) {
            Node node = new Node(key);
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                remove(oldNode);
                this.runningTime++;
            } else {
                this.runningTime += 5;
                if (map.size() >= this.capacity) {
                    Node delNode = lastNode.pre;
                    remove(delNode);
                }
            }
            insert(node);
        }

        public int getRunningTime(){
            return this.runningTime;
        }
    }

    public static class Node {
        private String key;
        private Node next;
        private Node pre;

        public Node(String key) {
            this.key = key;
        }
    }*/
}
