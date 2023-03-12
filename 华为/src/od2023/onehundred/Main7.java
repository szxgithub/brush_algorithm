package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {

    /*
        租车骑绿道

        部门组织绿岛骑行团建活动，每辆自行车最多坐两人，最大载重M

        给出部门每个人的体重，请问最多需要租用多少双人自行车


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 自行车限重
        int m = sc.nextInt();
        // 部门人数
        int n = sc.nextInt();

        // 部门每个人的体重 体重都小于等于自行车限重m
        int[] people = new int[n];
        for (int i=0; i<n; i++){
            people[i] = sc.nextInt();
        }

        int res = getResult(people, m);

        System.out.println(res);

    }

    /**
     *
     * 双指针  满分答案
     *
     * @param arr  部门每个人的体重
     * @param m 自行车最大载重
     * @return
     */
    public static int getResult(int[] arr, int m) {
        Arrays.sort(arr);

        int count = 0;

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] <= m){
                i++;
            }
            j--;
            count++;
        }

        // 此时还有一个人未分配到车因此需要count++
        if (i == j){
            count++;
        }

        return count;
    }

}
