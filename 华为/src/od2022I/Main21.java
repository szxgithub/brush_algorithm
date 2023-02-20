package od2022I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main21 {

    /**
     *
     * 素数之积
     *
     * 给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积
     *
     * 15
     * 3 5
     * 27
     * -1 -1
     *
     * */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){

            int num = scanner.nextInt();

            List<Integer> list = new ArrayList<>();

            int n = 0;
            while (n != num){
                num = n != 0 ? n : num;
                for (int i = 2; i < Math.sqrt(num) + 1; i++){
                    if (num%i == 0){
                        n = num/i; // 把商作为下次的被除数
                        list.add(i);
                        break;
                    }
                }
            }

            list.add(num);

            if (list.size() == 2){
                System.out.println(list.get(0) + " " + list.get(1));
            }else {
                System.out.println("-1 -1");
            }

        }

    }

}
