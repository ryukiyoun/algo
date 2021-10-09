package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        int cnt = 24;
        long[] numbers = new long[cnt];
        for(int i=0; i<cnt; i++)
            numbers[i] = i;

        solution.solution(numbers);
    }

    public static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                if(getRightToLeftBitOneCount(numbers[i]) == 0)
                    answer[i] = numbers[i] + 1;
                else
                    answer[i] = numbers[i] + (long)Math.pow(2, getRightToLeftBitOneCount(numbers[i]) - 1);
            }

            return answer;
        }

        public int getRightToLeftBitOneCount(long number){
            String bitString = Long.toBinaryString(number);

            int continuityOne = 0;
            for(int i = bitString.length()-1; i >-1; i--){
                if(bitString.charAt(i) == '1')
                    continuityOne++;
                else
                    break;
            }
            return continuityOne;
        }
    }
}
