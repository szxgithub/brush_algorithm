package od2023.onehundred;

import java.util.*;

public class Main5 {

    /*

    找出通过车辆最多颜色（最多颜色的车辆）

    车辆的颜色只有三种，编号为0，1，2
    找出N秒内经过的最多颜色的车辆

     */

    /**
     * 暴力破解 两层循环，据说满分
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 通过的车辆颜色信息
        String[] strs = sc.nextLine().split(" ");
        // 统计时间窗
        int n = sc.nextInt();

        int res = 0;
        for(int i=0; i<strs.length - n + 1; i++){
            //只有3种颜色，可以转化成长度3的数组
            int[] ints = new int[3];
            for(int j=i; j<i+n; j++){
                int index = Integer.valueOf(strs[j]);
                ints[index] ++;
            }
            int maxCount = Arrays.stream(ints).max().getAsInt();
            res = Math.max(res,maxCount);
        }

        System.out.println(res);

    }

    /**
     *
     * 采用滑动窗口方法
     *
     * @param arr 通过的车辆颜色信息
     * @param n 统计时间窗口
     * @return
     */
    public int getResult(Integer[] arr, int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);

        // 滑动窗口的左右边界
        int l = 0;
        int r = l + n;

        // 记录窗口内部最多的颜色数量
        int max= 0;

        for (int i = l; i < r; i++){
            Integer integer = arr[i];
            map.put(integer,map.get(integer) + 1);
            max = Math.max(max,map.get(integer));
        }

        while (r < arr.length){
            Integer add = arr[r++];
            Integer remove = arr[l++];
            map.put(add,map.get(add) + 1);
            map.put(remove,map.get(remove) - 1);

            max = Math.max(max,map.get(add));
        }

        return max;

    }

}
