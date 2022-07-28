package question;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0}, {1, 0}}, new int[][]{{1, 1}, {1, 0}}));
    }

    public static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int keySize = key.length - 1;

            for (int r = 0; r < 4; r++) {
                key = rotationKey(key);

                for (int y = 0; y < lock.length + keySize; y++) {
                    for (int x = 0; x < lock.length + keySize; x++) {
                        int[][] newLock = getExpansionLock(keySize, lock);

                        for (int ky = 0; ky < key.length; ky++) {
                            for (int kx = 0; kx < key.length; kx++)
                                newLock[ky + y][kx + x] += key[ky][kx];
                        }

                        if (check(newLock, keySize, lock.length + keySize))
                            return true;
                    }
                }
            }

            return false;
        }

        public int[][] rotationKey(int[][] key) {
            int[][] rotKey = new int[key.length][key.length];

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++)
                    rotKey[i][key.length - 1 - j] = key[j][i];
            }

            return rotKey;
        }

        public int[][] getExpansionLock(int keySize, int[][] lock) {
            int[][] newLock = new int[keySize * 2 + lock.length][keySize * 2 + lock.length];

            for (int i = keySize; i < keySize + lock.length; i++) {
                for (int j = keySize; j < keySize + lock.length; j++)
                    newLock[i][j] = lock[i - keySize][j - keySize];
            }

            return newLock;
        }

        public boolean check(int[][] newLock, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                for (int j = startIndex; j < endIndex; j++)
                    if (newLock[i][j] != 1)
                        return false;
            }
            return true;
        }
    }
}
