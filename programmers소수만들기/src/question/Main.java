package question;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,3,4,5,6,7}));
    }

    public static class Solution {
        private int answer = 0;

        public int solution(int[] nums) {
            boolean[] check = new boolean[nums.length];
            DFSAndPrime(nums, check, 0, 3);

            return answer;
        }

        public void DFSAndPrime(int[] arr, boolean[] check, int index, int r) {
            if (r == 0) {
                isPrime(arr, check);
                return;
            }

            for (int i = index; i < arr.length; i++) {
                check[i] = true;
                DFSAndPrime(arr, check, i + 1, r - 1);
                check[i] = false;
            }
        }

        public void isPrime(int[] arr, boolean[] check){
            int num = 0;
            for(int i=0; i<arr.length; i++){
                if(check[i]) {
                    num += arr[i];
                }
            }

            if (num == 2)
                answer++;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0)
                    return;
            }

            answer++;
        }
    }
}
