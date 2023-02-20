package od2023;

import java.util.*;

public class Main94 {

    /*

    士兵过河II

    1、首先让用时最短的两个士兵A、B划船过河到对岸，用时A<=B
    2、然后让B留在对岸，让最快的士兵划船回来本岸
    3、然后让本岸用时最长的两个士兵划船过河到对岸
    4、然后再让对岸用时最短的士兵B划船回来本岸

    按以上逻辑循环，直到用时达到上限T，或者士兵全部运输完

     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 士兵数
        int N = sc.nextInt();
        // 敌军到达时长
        int T = sc.nextInt();

        // 每个士兵过河时长
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(sc.nextInt());
        }

        boolean isLeft = true;      //是否从左侧士兵开始过河
        boolean isRight = true;     //右侧士兵是否满足过河条件（排序后右侧士兵耗时长）
        int time = 0;       //过河时间
        int count = 0;      //过河士兵数量
        int returnTime = 0;     //最后一人的返程时间
        List<Integer> duian = new ArrayList<>();    //对岸的士兵集合

        while (list.size() != 0){

            Collections.sort(list);     //对士兵进行排序

            int a, b;       //坐船的两个士兵
            if(isLeft || !isRight){     //左侧士兵开始过河或者右侧士兵无法过河
                a = list.get(0);    //左侧第一个士兵
                b = list.get(1);    //左侧第二个士兵
                list.remove(0);     //过河的士兵需要移除
                list.remove(0);
            }else {
                a = list.get(list.size()-2);    //右侧第一个士兵（倒数第二个士兵）
                b = list.get(list.size()-1);    //右侧第二个士兵（倒数第一个士兵）
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }

            count += 2;
            int tempTime;   //当前两个士兵的过河最优时间
            if(a > b){
                tempTime = a < b*10 ? a : b*10;    //找出两人划船的最优方案
            }else {
                tempTime = b < a*10 ? b : a*10;
            }

            if(time + tempTime >= T){       //此时时间已经超时
                if(isLeft){     //如果是左侧的士兵则表示时间已经不够了（因为右侧士兵的耗时更长）
                    if(time + tempTime == T){   //时间刚刚好
                        time += tempTime;
                    }else {
                        count --;   //时间超了需要将此次过河的人剔除
                        time -= returnTime;     //上一次返程时间也取消了
                    }
                    break;  //跳出循环，表示之后不能有士兵过河了
                }else {
                    count -= 2;     //过河人数还原
                    isRight = false;    //右侧不再满足过河的时间
                    isLeft = true;
                    list.add(a);    //过河士兵返回岸边
                    list.add(b);
                }
            }else {

                time += tempTime;   //到此刻士兵过河所花的时间和

                if(list.size() == 0){   //士兵已经全部过河直接跳出循环
                    break;
                }

                duian.add(a);   //对岸的士兵集合添加两个已经过河的士兵
                duian.add(b);

                Collections.sort(duian);    //求出对岸滑的最快的士兵，让他返程
                returnTime = duian.get(0);
                time += returnTime;   //最快的士兵返程所花时间也要加上

                if(time >= T){  //此时时间已经超时
                    time -= duian.get(0);   //减去返程所花的时间
                    if(isLeft){
                        break;  //如果是左侧士兵则表示之后没有士兵能够过河
                    }else {
                        time -= tempTime;   //右侧士兵则恢复原样，让左侧的士兵再试试
                        isRight = false;    //右侧士兵不能再过河了
                        isLeft = true;
                        count -= 2;     //过河人数还原
                        duian.remove(duian.size()-1);   //对岸的士兵返回岸边
                        duian.remove(duian.size()-1);
                        list.add(a);
                        list.add(b);
                    }
                }else {
                    list.add(duian.get(0));     //岸边添加返程的士兵
                    duian.remove(0);    //对岸移除返程的士兵
                    isLeft = isRight ? !isLeft : true;      //如果右侧士兵无法过河则永远从左侧士兵中选
                    count --;       //过河人数减一（因为返程了）
                }
            }
        }

        System.out.println(count + " " + time);
    }


    /*
    这道题是经典的吊桥谜题的变种题

    这道题非常难， 采用动态规划思想可解决

     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        System.out.println(getResult(n, t, times));
    }

    public static String getResult(int n, int t, int[] times) {
        Arrays.sort(times);

        // dp[i] 的含义是0-i士兵全部过河所需要的最短时间
        int[] dp = new int[n];

        dp[0] = times[0];
        if (dp[0] > t){
            return "0 0";
        }

        dp[1] = getMax(times[0], times[1]);
        if (dp[1] > t){
            return 1 + " " + dp[0];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + times[0] + getMax(times[0], times[i]),
                    dp[i - 2] + times[0] + getMax(times[i - 1], times[i]) + times[1] + getMax(times[0], times[1]));

            if (dp[i] > t) {
                return i + " " + dp[i - 1];
            }
        }

        return n + " " + dp[n - 1];
    }

    public static int getMax(int t1, int t2) {
        if (t1 * 10 < t2) {
            return t1 * 10;
        }
        return t2;
    }



}
