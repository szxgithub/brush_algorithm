package od2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main44 {

    /*
        租车骑绿道

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 自行车限重
        int m = sc.nextInt();
        // 部门人数
        int n = sc.nextInt();

        Integer[] people = new Integer[n];
        for (int i=0; i<n; i++){
            people[i] = sc.nextInt();
        }

        // 降序排序
        Arrays.sort(people, (o1, o2) -> o2- o1);

        int res = 0;
        for (int i = 0; i< people.length; i++){
            if (people[i] == 0){
                continue;
            }
            if (people[i] == m){
                res++;
                continue;
            }
            for (int j = i+1; j < people.length; j++){
                if (people[j] != 0 && people[j] + people[i] <= m){
                    people[i] = 0;
                    people[j] = 0;
                    res++;
                    break;
                }
            }
            if (people[i] != 0){
                res++;
            }
        }

        System.out.println(res);

    }

}
