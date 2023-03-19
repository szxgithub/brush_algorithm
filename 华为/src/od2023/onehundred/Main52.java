package od2023.onehundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main52 {

    /*

    异常的打卡记录

    以下两种情况，被认为异常打卡：
    1、实际设备 与 注册设备号不一致
    2、同一个员工两个打卡时间小于60分钟，且打卡距离超过5km

    给定打卡记录的字符串数组checkRecords，要求输出异常的打卡记录

    输入描述：
        输入N，打卡记录数
        之后N行为打卡记录
    输出描述：
        输出异常的打卡记录

输入：
2
100000,10,1,ABCD,ABCD
100001,80,10,ABCE,ABCE
输出：
NULL

     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 打卡记录数
        int N = sc.nextInt();
        sc.nextLine();

        List<Record> list = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        for(int i=0; i<N; i++){
            String[] strings = sc.nextLine().split(",");
            int id = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[1]);
            int distance = Integer.parseInt(strings[2]);
            String actualId = strings[3];
            String registerId = strings[4];
            Record record = new Record( id, time, distance, actualId, registerId);
            list.add(record);
        }

        for(int i=0; i<list.size(); i++){
            Record record1 = list.get(i);
            if(!record1.actualId.equals(record1.registerId)){   //实际与注册不一致直接异常
                resList.add(record1.toString());
                continue;
            }

            // 查找工号相同的打卡记录 判断打卡时间间隔与打卡距离是否符合要求
            for(int j=i+1; j<list.size(); j++){
                Record record2 = list.get(j);
                if(record2.id != record1.id){   //两个工号不一致不需要进行比较
                    continue;
                }
                int timeDifference = Math.abs(record1.time - record2.time);     //两打卡时间间隔
                int distanceDifference = Math.abs(record1.distance - record2.distance); //两打卡距离
                if(timeDifference<60 && distanceDifference>5){
                    resList.add(record1.toString());
                    resList.add(record2.toString());
                    break;
                }
            }
        }

        if(resList.size() == 0){
            // 无异常打卡记录
            System.out.println("NULL");
        }else {
            String res = "";
            for (String s : resList){
                res += s + ";";
            }
            System.out.println(res.substring(0, res.length()-1));
        }

    }

    /**
     * id：工号;
     * time：时间（分钟）;
     * distance：打卡距离（km）;
     * actualId：实际设备号;
     * registerId：注册设备号
     */
    static class Record{

        int id;
        int time;
        int distance;
        String actualId;
        String registerId;

        public Record(int id,int time,int distance,String actualId,String registerId){

            this.id = id;
            this.time = time;
            this.distance = distance;
            this.actualId = actualId;
            this.registerId = registerId;

        }

        @Override
        public String toString() {
            return   id +
                    "," + time +
                    "," + distance +
                    "," + actualId +
                    "," + registerId;
        }
    }
}
