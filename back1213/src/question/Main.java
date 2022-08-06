package question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//재풀이
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Palindrome palindrome = new Palindrome(br.readLine());

        System.out.println(palindrome.makePalindrome());
    }

    public static class Palindrome {
        int[] alpha = new int[26];
        String[] nameArr;

        public Palindrome(String name) {
            nameArr = new String[name.length()];

            for (char sub : name.toCharArray())
                alpha[sub - 65]++;
        }

        public boolean isPalindrome() {
            boolean odd = false;
            for (int i = 0; i < 26; i++) {
                if ((alpha[i] & 1) == 1) {
                    if (!odd)
                        odd = true;
                    else
                        return false;
                }
            }
            return true;
        }

        public String makePalindrome() {
            if (!isPalindrome())
                return "I'm Sorry Hansoo";

            StringBuilder halfPalindromeNameBuilder = new StringBuilder();

            int oddIndex = -1;
            for (int i = 25; i > -1; i--) {
                if((alpha[i] & 1) == 1)
                    oddIndex = i;

                halfPalindromeNameBuilder.append(Character.toString(i + 65).repeat(alpha[i]/2));
            }

            String halfPalindromeName = halfPalindromeNameBuilder.toString();
            halfPalindromeNameBuilder.reverse().append(halfPalindromeName);

            if(oddIndex != -1)
                halfPalindromeNameBuilder.insert(nameArr.length / 2, Character.toString(oddIndex + 65));

            return halfPalindromeNameBuilder.toString();
        }
    }
}
