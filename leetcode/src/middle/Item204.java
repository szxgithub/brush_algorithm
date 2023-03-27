package middle;

import java.util.Arrays;

public class Item204 {

    /*
    计数质数
     */

    public int countPrimes(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);

        for (int i = 2; i*i <n; i++){
            if (isPrime[i]){
                // 如果i是素数，i的倍数就不可能是素数
                for (int j = i*i; j <n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <n; i++){
            if (isPrime[i]){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }

}
