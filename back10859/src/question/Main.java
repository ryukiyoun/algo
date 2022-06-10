package question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
//todo 문제해결 못함
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        RotationPrime rotationPrime = new RotationPrime(br.readLine());

        bw.write(rotationPrime.printResult() + "\n");
        bw.flush();
    }

    public static class RotationPrime{
        private final String[] rotationResult = {"0", "1", "2", "", "", "5", "9", "", "8", "6"};
        private String rotationNumber = "";

        private boolean isPrime = false;

        public RotationPrime(String number){
            if(isPrime = isPrime(number))
                rotationNumber = rotationNumber(number);
        }

        public String rotationNumber(String number){
            StringBuilder stringBuilder = new StringBuilder();
            for(char num : number.toCharArray()) {
                if (!rotationResult[Character.getNumericValue(num)].equals(""))
                    stringBuilder.append(rotationResult[Character.getNumericValue(num)]);
                else
                    return null;
            }

            return stringBuilder.reverse().toString();
        }

        public boolean isPrime(String num) {
            BigInteger number = new BigInteger(num);

            if (number.compareTo(BigInteger.valueOf(2)) < 0)
                return false;

            if (number.compareTo(BigInteger.valueOf(2)) == 0)
                return true;

            BigInteger compareNum = new BigInteger("2");
            while (compareNum.compareTo(number.sqrt()) <= 0) {
                if (number.mod(compareNum).compareTo(BigInteger.ZERO) == 0)
                    return false;

                compareNum = compareNum.add(BigInteger.ONE);
            }

            return true;
        }

        public boolean isRotationPrime(){
            if(rotationNumber == null)
                return false;
            else{
                BigInteger number = new BigInteger(rotationNumber);

                if(number.compareTo(BigInteger.valueOf(2)) < 0)
                    return false;

                if(number.compareTo(BigInteger.valueOf(2)) == 0)
                    return true;

                BigInteger compareNum = new BigInteger("2");
                while(compareNum.compareTo(number.sqrt()) <= 0){
                    if(number.mod(compareNum).compareTo(BigInteger.ZERO) == 0)
                        return false;

                    compareNum = compareNum.add(BigInteger.ONE);
                }

                return true;
            }
        }

        public String printResult(){
            if(!isPrime)
                return "no";
            else{
                isPrime = isRotationPrime();

                if(!isPrime)
                    return "no";
                else
                    return "yes";
            }
        }
    }
}
