package od2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main12 {

    /*

    统计匹配的二元组个数

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] A = new int[n1];
        for (int i = 0; i<n1; i++){
            A[i] = sc.nextInt();
        }

        int[] B = new int[n2];
        for (int i = 0; i<n2; i++){
            B[i] = sc.nextInt();
        }

        // 要求时间复杂度小于O(n^2)
        Arrays.sort(A);
        Arrays.sort(B);


        int count = 0;
        for (int i =0; i<A.length; i++){
            for (int j = 0;j<B.length; j++){
                if (A[i] > B[j]){
                    continue;
                }else if (A[i] < B[j]){
                    break;
                }else {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    /**
     * 推荐这种解法
     * @param args
     */
    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] A = new int[n1];
        for (int i = 0; i<n1; i++){
            A[i] = sc.nextInt();
        }

        int[] B = new int[n2];
        for (int i = 0; i<n2; i++){
            B[i] = sc.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<A.length; i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }

        int res = 0;
        for (int i = 0;i<B.length; i++){
            if (map.containsKey(B[i])){
                res += map.get(B[i]);
            }
        }

        System.out.println(res);

    }


}
