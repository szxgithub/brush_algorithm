package od2023.onehundred;

import java.util.*;

public class Main60 {

    /*

    新员工座位安排系统 可以直接暴力模拟

    工位由序列F1,F2,...Fn组成，Fi值为0、1或2，其中0代表空置，1代表有人，2代表障碍物
    1、某一空位的友好度为左右连续老员工数之和
    2、为方便新员工学习求助，优先安排友好度高的空位

    给出工位序列，求所有空位中友好度的最大值

    下面这个解法很巧妙


     */

    /*
    逻辑分析
     */

    /*
    从左向右，从右向左计算
     */
    public static int getResult(String[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int friendShip = 0;
        for (int i = 0; i< arr.length; i++){
            switch (arr[i]){
                case "0":
                    map.put(i,friendShip);
                    friendShip = 0;
                    break;
                case "1":
                    friendShip++;
                    break;
                case "2":
                    friendShip = 0;
                    break;
            }
        }

        friendShip = 0;
        int ans = 0;
        for (int i = arr.length - 1; i>= 0; i--){
            switch (arr[i]){
                case "0":
                    ans = Math.max(ans,map.get(i) + friendShip);
                    friendShip = 0;
                    break;
                case "1":
                    friendShip++;
                    break;
                case "2":
                    friendShip = 0;
                    break;
            }
        }
        return ans;
    }

}
