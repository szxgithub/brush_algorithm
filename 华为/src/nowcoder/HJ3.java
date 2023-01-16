package nowcoder;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            int N = sc.nextInt();

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < N; i++){
                int tmp = sc.nextInt();
                treeSet.add(tmp);
            }

            for (Integer num : treeSet){
                System.out.println(num);
            }
        }


    }

}
